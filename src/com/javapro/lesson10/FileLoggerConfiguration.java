package com.javapro.lesson10;

import com.javapro.lesson10.api.LogginLevel;

public class FileLoggerConfiguration {

  private String nameFile;
  private LogginLevel level;
  private int maxSizeByte;
  private String nameFormat;


  public FileLoggerConfiguration() {

  }

  public String getNameFile() {
    return nameFile;
  }

  public void setNameFile(String nameFile) {
    this.nameFile = nameFile;
  }

  public LogginLevel getLevel() {
    return level;
  }

  public void setLevel(String level) {
    switch (level) {
      case "INFO" -> this.level = LogginLevel.INFO;
      case "DEBUG" -> this.level = LogginLevel.DEBUG;
    }

  }

  public int getMaxSizeByte() {
    return maxSizeByte;
  }

  public void setMaxSizeByte(String maxSizeByte) {
    int a;
    try {
      a = Integer.parseInt(maxSizeByte);
    } catch (NumberFormatException e) {
      throw new NumberFormatException(maxSizeByte);
    }
    this.maxSizeByte = a;
  }


  public String getNameFormat() {
    return nameFormat;
  }

  public void setNameFormat(String nameFormat) {
    this.nameFormat = nameFormat;
  }

  public boolean isValidRule(LogginLevel level) {
    return level.ordinal() <= this.level.ordinal();
  }

  @Override
  public String toString() {
    return "FileLoggerConfiguration{" +
        "FILE:" + nameFile + '\'' +
        ", LEVEL=" + level +
        ", MAX-SIZE=" + maxSizeByte +
        ", FORMAT='" + nameFormat + '\'' +
        '}';
  }
}
