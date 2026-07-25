package com.designPatterns.decorator;

public class LoggingDecorator extends PrinterDecorator{

    public LoggingDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text){
        System.out.println("Logging: "+text);
        super.print(text);
    }
}
