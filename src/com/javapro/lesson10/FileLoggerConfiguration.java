package com.javapro.lesson10;

import com.javapro.lesson10.api.LoggingLevel;

public class FileLoggerConfiguration {

  private String nameFile;
  private LoggingLevel level;
  private int maxSizeByte;
  private String nameFormat;

  public FileLoggerConfiguration() {

  }

  public FileLoggerConfiguration(String nameFile, LoggingLevel level, int maxSizeByte,
      String nameFormat) {
    this.nameFile = nameFile;
    this.level = level;
    this.maxSizeByte = maxSizeByte;
    this.nameFormat = nameFormat;
  }

  public String getNameFile() {
    return nameFile;
  }

  public void setNameFile(String nameFile) {
    this.nameFile = nameFile;
  }

  public LoggingLevel getLevel() {
    return level;
  }

  public void setLevel(String level) {
    switch (level) {
      case "INFO" -> this.level = LoggingLevel.INFO;
      case "DEBUG" -> this.level = LoggingLevel.DEBUG;
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

  public boolean isValidRule(LoggingLevel level) {
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
