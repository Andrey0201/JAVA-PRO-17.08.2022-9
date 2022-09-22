package com.javapro.lesson10;

import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {

  private final String FILE_PATH = "D:\\Java\\JAVA-PRO-17.08.2022-9\\src\\com\\javapro\\lesson10\\file\\config.txt";

  public FileLoggerConfiguration load() {

    return parsConfigurationString();
  }


  private String getStringFromFile() {
    StringBuilder s = new StringBuilder();
    try (FileReader reader = new FileReader(
        FILE_PATH)) {
      int c;
      while ((c = reader.read()) != -1) {
        s.append((char) c);
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return s.toString();
  }


  private FileLoggerConfiguration parsConfigurationString() {
    FileLoggerConfiguration configuration = new FileLoggerConfiguration();
    String[] str = getStringFromFile().split("\n");
    for (int i = 0; i < str.length; i++) {
      int index = str[i].indexOf(":");
      String key = str[i].substring(0, index);
      String value = str[i].substring(index + 1);
      switch (key) {
        case "FILE" -> configuration.setNameFile(value.trim());
        case "LEVEL" -> configuration.setLevel(value.trim());
        case "MAX-SIZE" -> configuration.setMaxSizeByte(value.trim());
        case "FORMAT" -> configuration.setNameFormat(value.trim());
      }
    }
    return configuration;
  }

}
