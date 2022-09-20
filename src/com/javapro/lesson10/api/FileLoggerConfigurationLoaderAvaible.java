package com.javapro.lesson10.api;

import com.javapro.lesson10.FileLoggerConfiguration;

public interface FileLoggerConfigurationLoaderAvaible {


  String getStringFromFile();

  FileLoggerConfiguration parsConfigurationString();
}
