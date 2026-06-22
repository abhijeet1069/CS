package com.designPatterns.behavior.chainOfResponsibility;

public class Main {
	public static void main(String[] args) {
        Logger errorLogger = new ErrorLogger();
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();

        errorLogger.setNext(debugLogger);
        debugLogger.setNext(infoLogger);

        Logger loggerChain = errorLogger;

        loggerChain.logMessage(Logger.INFO, "This is an info message"); // First line
        loggerChain.logMessage(Logger.DEBUG, "This is a debug message"); // Next two lines
        loggerChain.logMessage(Logger.ERROR, "This is an error message"); //Next 3 lines
        
        /**Output:
         *  INFO: This is an info message
			DEBUG: This is a debug message
			INFO: This is a debug message
			ERROR: This is an error message
			DEBUG: This is an error message
			INFO: This is an error message
         * */
    }
}
