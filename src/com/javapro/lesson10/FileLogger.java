package com.javapro.lesson10;


import com.javapro.lesson10.api.FileLoggerAvaible;
import com.javapro.lesson10.api.LogginLevel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements FileLoggerAvaible {

  private FileLoggerConfiguration configuration = new FileLoggerConfiguration("Name",
      LogginLevel.DEBUG,
      500, ".txt");
  SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
  Date date = new Date(System.currentTimeMillis());

  String totalNameFile = configuration.getNameFile() + configuration.getNameFormat();

  @Override
  public void debug(String str) {
    if (getFile().length() <= configuration.getMaxSizeByte()) {
      writeFile(str, LogginLevel.DEBUG);
    } else {
      throw new FileMaxSizeReachedException(getFile().length(), configuration.getMaxSizeByte());
    }

    System.out.printf("[%s][%s][%s]\n", formatter.format(date), LogginLevel.DEBUG, str);
    System.out.println(getFile().length());

  }

  @Override
  public void info(String str) {
    if (getFile().length() <= configuration.getMaxSizeByte()) {
      writeFile(str, LogginLevel.INFO);
    } else {
      throw new FileMaxSizeReachedException(getFile().length(), configuration.getMaxSizeByte());
    }
    System.out.printf("[%s][%s][%s]\n", formatter.format(date), LogginLevel.INFO, str);
    System.out.println(getFile().length());

  }

  private void writeFile(String str, LogginLevel level) {
    File file = getFile();
    String newStr = String.format("[%s][%s][%s]\n", formatter.format(date), level, str);
    if (configuration.isValidRule(level)) {
      try (OutputStream os = new FileOutputStream(file, true)) {
        os.write(newStr.getBytes(StandardCharsets.UTF_8));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private File getFile() {
    File fd = new File("D:\\Java\\JAVA-PRO-17.08.2022-9\\src\\com\\javapro\\lesson10\\file\\");
    File file = new File(fd,totalNameFile);
    try {
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return file;
  }


}
