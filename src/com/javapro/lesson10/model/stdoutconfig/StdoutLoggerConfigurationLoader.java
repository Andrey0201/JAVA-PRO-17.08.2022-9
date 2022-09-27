package com.javapro.lesson10.model.stdoutconfig;

import com.javapro.lesson10.api.ILoggerConfigurationLoader;
import com.javapro.lesson10.model.fileconfig.FileLoggerConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StdoutLoggerConfigurationLoader implements ILoggerConfigurationLoader {

  /**
   * Релизуем ввод данных с консоли, сейчас оставил возможность брать
   * конфигурацию(В данном случаи level) с my.config.properties
   * */
    @Override
    public FileLoggerConfiguration load() {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();
        try (InputStream input = new FileInputStream("my.config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            configuration.setLevel(prop.getProperty("logging_level"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return configuration;
    }
}
