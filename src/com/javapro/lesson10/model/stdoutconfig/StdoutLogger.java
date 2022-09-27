package com.javapro.lesson10.model.stdoutconfig;

import com.javapro.lesson10.api.ILoggerConfigurationLoader;
import com.javapro.lesson10.api.LoggerAvailable;
import com.javapro.lesson10.api.LoggingLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdoutLogger implements LoggerAvailable {

    ILoggerConfigurationLoader loader = new StdoutLoggerConfigurationLoader();

     Date date = new Date(System.currentTimeMillis());
     SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH-mm-ss");

    @Override
    public void debug(String text) {
        print(text,LoggingLevel.DEBUG);
    }

    @Override
    public void info(String text) {
        print(text,LoggingLevel.INFO);

    }

    private void print(String str, LoggingLevel level) {
        String newStr = String.format("[%s][%s] Сообщение:[%s]", formatter.format(date), level, str);
        if (loader.load().isValidRule(level)) {
            System.out.println(newStr);
        }
    }
}