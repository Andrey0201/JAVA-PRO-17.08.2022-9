package com.javapro.lesson10;


import com.javapro.lesson10.api.LogginLevel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {


  FileLoggerConfiguration configuration = new FileLoggerConfiguration("Name ", LogginLevel.INFO,
      500, ".txt");
  SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
  Date date = new Date(System.currentTimeMillis());


  public void debug(LogginLevel level) {
    if (level == LogginLevel.DEBUG) {
      System.out.println(" Записать DEBUG и INFO в файл Log_" + formatter.format(date)
          + configuration.getNameFormat());
    }
  }

  public void info(LogginLevel level) {
    if (level == LogginLevel.INFO) {
      System.out.println(" Записать  INFO в файл Log_" + formatter.format(date)
          + configuration.getNameFormat());

    }
  }
}
