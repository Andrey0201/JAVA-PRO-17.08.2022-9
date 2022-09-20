package com.javapro.lesson10;

public class FileLoggerConfigurationLoader {

    private final String FILE_PATH = "D:\\Java\\JAVA-PRO-17.08.2022-9\\src\\com\\javapro\\lesson10\\file\\config.txt";

    public FileLoggerConfiguration load(){

        return parsConfigurationString(getStringFromFile());
    }

    private String getStringFromFile(){

        return "";
    }
    private FileLoggerConfiguration parsConfigurationString(String str){
        FileLoggerConfiguration configuration  = new FileLoggerConfiguration();
        str.split("\n");
        return configuration;
    }
}
