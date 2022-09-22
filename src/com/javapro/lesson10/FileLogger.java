package com.javapro.lesson10;


import com.javapro.lesson10.api.FileLoggerAvaible;
import com.javapro.lesson10.api.LoggingLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements FileLoggerAvaible {

  private FileLoggerConfiguration configuration = new FileLoggerConfiguration(".\\src\\com\\javapro\\lesson10\\file\\log_",
      LoggingLevel.DEBUG,
      500, ".txt");
  Date date = new Date(System.currentTimeMillis());
  SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
  String totalNameFile = configuration.getNameFile() + configuration.getNameFormat();

  @Override
  public void debug(String str) {
    if (getFile().length() <= configuration.getMaxSizeByte()) {
      writeFile(str, LoggingLevel.DEBUG);
    } else {
      throw new FileMaxSizeReachedException(getFile().length(), configuration.getMaxSizeByte());
    }
  }

  @Override
  public void info(String str) {
    if (getFile().length() <= configuration.getMaxSizeByte()) {
      writeFile(str, LoggingLevel.INFO);
    } else {
      throw new FileMaxSizeReachedException(getFile().length(), configuration.getMaxSizeByte());
    }
  }

  private File getFile() {
    return new File(totalNameFile);
  }

  private void writeFile(String str, LoggingLevel level) {
    File file = getFile();
    String newStr = String.format("[%s][%s] Сообщение:[%s]\n", formatter.format(date), level, str);
    if (configuration.isValidRule(level)) {
      try (FileWriter writer = new FileWriter(file, true)) {
        writer.append(newStr);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
