package com.javapro.lesson10;


import com.javapro.lesson10.api.FileLoggerAvaible;
import com.javapro.lesson10.api.LogginLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class FileLogger implements FileLoggerAvaible {
  FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();



//  private FileLoggerConfiguration configuration = new FileLoggerConfiguration("log_",
//      LogginLevel.DEBUG,
//      500, ".txt");
  Date date = new Date(System.currentTimeMillis());
  SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH-mm");

  String totalNameFile =
      loader.load().getNameFile() +    loader.load().getNameFormat();

  @Override
  public void debug(String str) {
    if (getFile().length() <=  loader.load().getMaxSizeByte()) {
      writeFile(str, LogginLevel.DEBUG);
    } else {
      getFile();
      writeFile(str, LogginLevel.DEBUG);
    }
    System.out.printf("[%s][%s] Сообщение: [%s]\n", formatter.format(date), LogginLevel.DEBUG, str);
    System.out.println(getFile().length());

  }

  @Override
  public void info(String str) {
    if (getFile().length() <=  loader.load().getMaxSizeByte()) {
      writeFile(str, LogginLevel.INFO);
    } else {
      getFile();
      writeFile(str, LogginLevel.INFO);
    }
    System.out.printf("[%s][%s][%s]\n", formatter.format(date), LogginLevel.INFO, str);
    System.out.println(getFile().length());

  }

  private File getFile() {
    return  new File(loader.load().getNameFile()+loader.load().getNameFormat());
  }

  private void writeFile(String str, LogginLevel level) {
    String newStr = String.format("[%s][%s] Сообщение:[%s]\n", formatter.format(date), level, str);
    if ( loader.load().isValidRule(level)) {
      try (FileWriter writer = new FileWriter(getFile(), true)) {
        writer.append(newStr);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


}
