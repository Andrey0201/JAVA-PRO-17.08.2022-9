package com.javapro.lesson10;

import com.javapro.lesson10.api.LogginLevel;

public class FileLoggerConfiguration {

  public FileLoggerConfiguration(String nameFile, LogginLevel level, int maxSizeByte,
      String nameFormat) {
    this.nameFile = nameFile;
    this.level = level;
    this.maxSizeByte = maxSizeByte;
    this.nameFormat = nameFormat;
  }


  private String nameFile;
  private LogginLevel level;
  private int maxSizeByte;
  private String nameFormat;

  public String getNameFile() {
    return nameFile;
  }

  public int getMaxSizeByte() {
    return maxSizeByte;
  }

  public String getNameFormat() {
    return nameFormat;
  }

  public LogginLevel getLevel() {
    return level;
  }
}
