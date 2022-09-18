import com.javapro.lesson10.FileLogger;
import com.javapro.lesson10.api.LogginLevel;


public class Main {

  public static void main(String[] args) {
    FileLogger fileLogger = new FileLogger();
    fileLogger.debug(LogginLevel.DEBUG);
    fileLogger.info(LogginLevel.INFO);
  }
}