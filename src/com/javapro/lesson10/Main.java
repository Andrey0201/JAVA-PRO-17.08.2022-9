package com.javapro.lesson10;

import com.javapro.lesson10.model.fileconfig.FileLogger;
import com.javapro.lesson10.api.LoggerAvailable;
import com.javapro.lesson10.model.fileconfig.FileLoggerConfigurationLoader;
import com.javapro.lesson10.model.stdoutconfig.StdoutLogger;


public class Main {

    public static void main(String[] args) {
        LoggerAvailable fileLogger = new FileLogger();

        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        System.out.println(loader.load().toString());

        fileLogger.debug("Что-то пошло не так");
        fileLogger.info("Информация");

        LoggerAvailable outLogger = new StdoutLogger();
        outLogger.debug("!!!Что-то пошло не так!!!");
        outLogger.info("!!!Информация!!!");
    }
}
