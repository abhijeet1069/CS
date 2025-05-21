package com.satyam.creationalPatterns.abstractFactory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;
        
        // Usually, you'd detect OS or config dynamically
        String osName = "windows";

        if (osName.contains("windows")) {
            factory = new WindowsFactory();
        } else if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            throw new RuntimeException("Unsupported OS");
        }

        Application app = new Application(factory);
        app.paint();
    }
}

