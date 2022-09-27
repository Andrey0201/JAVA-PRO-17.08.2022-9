package com.javapro.lesson10;

import com.javapro.lesson10.model.fileconfig.FileLogger;
import com.javapro.lesson10.model.fileconfig.FileLoggerConfigurationLoader;
import com.javapro.lesson10.api.FileMaxSizeReachedException;
import com.javapro.lesson10.api.FileLoggerAvaible;


public class Main {

  public static void main(String[] args) {
    FileLoggerAvaible fileLogger = new FileLogger();
    try {
      fileLogger.debug("Что-то пошло не так");
      fileLogger.info("Информация");
    } catch (FileMaxSizeReachedException e) {
      System.out.println(e.getMessage());
    }

    FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
    System.out.println(loader.load().toString());

  }
}