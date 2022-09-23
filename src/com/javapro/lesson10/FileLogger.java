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

  Date date = new Date(System.currentTimeMillis());
  SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH-mm");

  @Override
  public void debug(String str) {
      writeFile(str, LogginLevel.DEBUG);
  }

  @Override
  public void info(String str) {
      writeFile(str, LogginLevel.INFO);
  }

  private File createFile() {
    File file = new File(loader.load().getNameFile() + loader.load().getNameFormat());
    if (file.length() >= loader.load().getMaxSizeByte()) {
      file = new File(
          loader.load().getNameFile() + formatter.format(date) + loader.load().getNameFormat());
    }
    return file;
  }


  private void writeFile(String str, LogginLevel level) {
    String newStr = String.format("[%s][%s] Сообщение:[%s]\n", formatter.format(date), level, str);
    if (loader.load().isValidRule(level)) {
      try (FileWriter writer = new FileWriter(createFile(), true)) {
        writer.append(newStr);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


}
