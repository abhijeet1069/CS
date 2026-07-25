package com.designPatterns.behavior.chainOfResponsibility;

public class DebugLogger extends Logger {
    public DebugLogger() {
        this.level = DEBUG;
    }

    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}
