package com.designPatterns.decorator;

import java.util.Locale;

public class UpperCaseDecorator extends PrinterDecorator{

    public UpperCaseDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text){
        super.print(text.toUpperCase());
    }
}