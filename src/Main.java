import com.javapro.lesson10.FileLogger;
import com.javapro.lesson10.FileLoggerConfigurationLoader;
import com.javapro.lesson10.api.FileLoggerAvaible;

import java.io.FileReader;
import java.io.IOException;


public class Main {

  public static void main(String[] args) {
    FileLoggerAvaible fileLogger = new FileLogger();
//    fileLogger.debug("Что не так");
//    fileLogger.info("Информация");
    FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
    System.out.println(loader.load().getNameFile());
    System.out.println(loader.load().getLevel());
    System.out.println(loader.load().getMaxSizeByte());
    System.out.println(loader.load().getNameFormat());


//    pars();
    //  System.out.println(readFile());

//    pars2();


  }


//  private static void pars() {
//    String str = "FILE:\"D:\\JAVA\\JAVA-PRO-17.08.2022-9\\src\\com\\javapro\\lesson10\\file]\\Name\"";
//    int index = str.indexOf(":");
//    String key = str.substring(0, index);
//    String value = str.substring(index + 1);
//    System.out.println(key);
//    FileLoggerConfiguration configuration = new FileLoggerConfiguration();
//    switch (key) {
//      case "FILE" -> configuration.setNameFile(value);
//    }
//    System.out.println(configuration.getNameFile());
//

//  public static String readFile() {
//    StringBuilder s = new StringBuilder();
//    try (FileReader reader = new FileReader(
//        "D:\\Java\\JAVA-PRO-17.08.2022-9\\src\\com\\javapro\\lesson10\\file\\config.txt")) {
//      int c;
//      while ((c = reader.read()) != -1) {
//        s.append((char) c);
//      }
//    } catch (IOException e) {
//      System.out.println(e.getMessage());
//    }
//    return s.toString();
//  }
//
//  private static void pars2() {
//
//    String[] str = readFile().split("\n");
//    for (int i = 0; i < str.length; i++) {
//      int index = str[i].indexOf(":");
//      String key = str[i].substring(0, index);
//      String value = str[i].substring(index + 1);
//      switch (key) {
//        case "FILE", "LEVEL", "MAX-SIZE", "FORMAT" -> System.out.println(value);
//      }
//    }
//
//  }


}