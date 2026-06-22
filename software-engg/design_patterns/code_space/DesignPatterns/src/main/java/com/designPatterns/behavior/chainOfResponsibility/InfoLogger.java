package com.designPatterns.behavior.chainOfResponsibility;

public class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = INFO;
    }

    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}
