package srp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    private static final int LOCATION_WIDTH = 30; // total width of class + method

    private static String formatLocation() {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        String className = caller.getClassName();
        String methodName = caller.getMethodName() + "()";
        String location = className + " " + methodName;
        return String.format("%-" + LOCATION_WIDTH + "s", location); // pad whole block
    }

    public static void logError(Exception e) {
        String type = e.getClass().getSimpleName();
        String msg = String.format("[%s] %s", type, e.getMessage());
        logger.error("{} : {}", formatLocation(), msg);
    }

    public static void logInfo(String msg) {
        logger.info("{} : {}", formatLocation(), msg);
    }
}
