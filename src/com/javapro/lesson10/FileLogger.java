package com.javapro.lesson10;


import com.javapro.lesson10.api.FileLoggerAvaible;
import com.javapro.lesson10.api.LogginLevel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements FileLoggerAvaible {

    private FileLoggerConfiguration configuration = new FileLoggerConfiguration("Name",
            LogginLevel.DEBUG,
            500, ".txt");
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());

    String totalNameFile = configuration.getNameFile() + configuration.getNameFormat();

    @Override
    public void debug(String str) {
        writeFile(str, LogginLevel.DEBUG);

        System.out.printf("[%s][%s][%s]\n", formatter.format(date), LogginLevel.DEBUG, str);


    }

    @Override
    public void info(String str) {
        writeFile(str, LogginLevel.INFO);
        System.out.printf("[%s][%s][%s]\n", formatter.format(date), LogginLevel.INFO, str);

    }

    private void writeFile(String str, LogginLevel level) {
        File file = getFile();
        String newStr = String.format("[%s][%s][%s]\n", formatter.format(date), level, str);
        if (configuration.isValidRule(level)) {
            try (OutputStream os = new FileOutputStream(file, true)) {
                os.write(newStr.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File getFile() {
        File file = new File("D:\\Java\\JAVA-PRO\\JAVA-PRO-17.08.2022-9\\src\\com\\javapro\\lesson10\\"
                + "file", totalNameFile);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


}
