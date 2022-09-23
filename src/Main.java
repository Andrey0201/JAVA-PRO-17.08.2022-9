import com.javapro.lesson10.FileLogger;
import com.javapro.lesson10.FileLoggerConfigurationLoader;
import com.javapro.lesson10.api.FileLoggerAvaible;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Main {

  public static void main(String[] args) {
    FileLoggerAvaible fileLogger = new FileLogger();
    fileLogger.debug("Что-то пошло не так");
    fileLogger.info("Информация");
    FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
    System.out.println(loader.load().toString());

  }
}