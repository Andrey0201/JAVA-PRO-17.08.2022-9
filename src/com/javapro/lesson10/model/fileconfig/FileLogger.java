package com.javapro.lesson10.model.fileconfig;


import com.javapro.lesson10.api.ILoggerConfigurationLoader;
import com.javapro.lesson10.api.LoggerAvailable;
import com.javapro.lesson10.api.LoggingLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger implements LoggerAvailable {

    ILoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();

    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH-mm-ss");
    String totalName = "log_" + formatter.format(date) + loader.load().getNameFormat();

    @Override
    public void debug(String str) {
        writeFile(str, LoggingLevel.DEBUG);
    }

    @Override
    public void info(String str) {
        writeFile(str, LoggingLevel.INFO);
    }

    private File createFile() {

        return new File(loader.load().getNameFile() + totalName);
    }

    private File getFile() {
        File dir = new File(loader.load().getNameFile());
        try {
            File[] files = dir.listFiles();
            if (files == null || files.length == 0) {
                return createFile();
            } else {
                File lastModifiedFile = files[0];
                for (int i = 1; i < files.length; i++) {
                    if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                        lastModifiedFile = files[i];
                    }
                }
                if (lastModifiedFile.length() <= loader.load().getMaxSizeByte()) {
                    return lastModifiedFile;
                } else {
                    return createFile();
                }
            }
        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private void writeFile(String str, LoggingLevel level) {
        String newStr = String.format("[%s][%s] Сообщение:[%s]\n", formatter.format(date), level, str);
        if (loader.load().isValidRule(level)) {
            File temp = getFile();
            if (temp == null) return;
            try (FileWriter writer = new FileWriter(temp, true)) {
                writer.append(newStr);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
