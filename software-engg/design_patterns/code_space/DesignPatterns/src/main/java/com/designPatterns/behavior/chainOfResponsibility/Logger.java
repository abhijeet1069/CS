package com.designPatterns.behavior.chainOfResponsibility;

public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (next != null) {
            next.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}
