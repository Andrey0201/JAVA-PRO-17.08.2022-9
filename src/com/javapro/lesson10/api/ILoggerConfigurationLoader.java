package com.javapro.lesson10.api;

import com.javapro.lesson10.model.fileconfig.FileLoggerConfiguration;

public interface ILoggerConfigurationLoader {

    FileLoggerConfiguration load();
}
