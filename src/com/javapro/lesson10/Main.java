package com.javapro.lesson10;

import com.javapro.lesson10.model.FileLogger;
import com.javapro.lesson10.api.LoggerAvailable;
import com.javapro.lesson10.model.configuration.FileLoggerConfigurationLoader;


public class Main {

    public static void main(String[] args) {
        LoggerAvailable fileLogger = new FileLogger();
        int i = 2;
        while (i > 0) {
            fileLogger.debug("Что-то пошло не так");
            fileLogger.info("Информация");
            i--;
        }
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        System.out.println(loader.load().toString());
    }
}
