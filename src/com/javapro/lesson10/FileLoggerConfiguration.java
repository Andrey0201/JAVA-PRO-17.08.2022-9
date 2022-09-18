package com.javapro.lesson10;

import com.javapro.lesson10.api.LogginLevel;

public class FileLoggerConfiguration {

    private String nameFile;
    private LogginLevel level;
    private int maxSizeByte;
    private String nameFormat;

    public FileLoggerConfiguration() {

    }

    public FileLoggerConfiguration(String nameFile, LogginLevel level, int maxSizeByte,
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

    public LogginLevel getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level =LogginLevel.valueOf(level);//exeption
    }

    public int getMaxSizeByte() {
        return maxSizeByte;
    }

    public void setMaxSizeByte(String maxSizeByte) {
     // parsint this.maxSizeByte = maxSizeByte;
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
}
