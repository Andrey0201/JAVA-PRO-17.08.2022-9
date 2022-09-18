import com.javapro.lesson10.FileLogger;
import com.javapro.lesson10.FileLoggerConfiguration;
import com.javapro.lesson10.api.FileLoggerAvaible;
import com.javapro.lesson10.api.LogginLevel;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        FileLoggerAvaible fileLogger = new FileLogger();
        fileLogger.debug("Что не так");
        fileLogger.info("Информация");
        pars();


    }

    private static void pars() {
        String str = "FILE:\"D:\\JAVA\\JAVA-PRO\\JAVA-PRO-17.08.2022-9\\src\\com\\javapro\\lesson10\\file]\\Name\"";
        int index = str.indexOf(":");
        String key = str.substring(0, index);
        String value = str.substring(index + 1);
        System.out.println(key);
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();
        switch (key) {
            case "FILE" -> configuration.setNameFile(value);

        }
        System.out.println(configuration.getNameFile());

    }
}