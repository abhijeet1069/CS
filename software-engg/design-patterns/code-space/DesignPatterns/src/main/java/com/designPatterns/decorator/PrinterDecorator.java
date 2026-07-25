package com.designPatterns.decorator;

public abstract class PrinterDecorator implements Printer{

    protected Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        printer.print(text);
    }
}
