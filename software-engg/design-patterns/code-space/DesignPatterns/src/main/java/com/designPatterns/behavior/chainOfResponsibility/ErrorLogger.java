package com.designPatterns.behavior.chainOfResponsibility;

public class ErrorLogger extends Logger {
    public ErrorLogger() {
        this.level = ERROR;
    }

    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
