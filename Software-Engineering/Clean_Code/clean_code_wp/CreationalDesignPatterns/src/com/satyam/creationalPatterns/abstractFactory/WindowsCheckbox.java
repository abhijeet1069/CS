package com.satyam.creationalPatterns.abstractFactory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows-style checkbox.");
    }
}
