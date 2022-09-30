package com.javapro.lesson10.model.fileconfig;

import com.javapro.lesson10.api.ILoggerConfigurationLoader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader implements ILoggerConfigurationLoader {

  @Override
  public FileLoggerConfiguration load() {
    FileLoggerConfiguration configuration = new FileLoggerConfiguration();

    try {
      FileReader input = new FileReader("my.config.properties");
      Properties prop = new Properties();
      prop.load(input);
      configuration.setNameFile(prop.getProperty("file"));
      configuration.setLevel(prop.getProperty("logging_level"));
      configuration.setMaxSizeByte(prop.getProperty("max_size"));
      configuration.setNameFormat(prop.getProperty("format"));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    return configuration;
  }
}
