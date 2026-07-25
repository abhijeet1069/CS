package com.designPatterns.decorator;

/**
 * Logging: HELLO WORLD
 * HELLO WORLD
 *
 * UppercaseDecorator.print()
 *
 *         │
 *         ▼
 * LoggingDecorator.print()
 *
 *         │
 *         ▼
 * ConsolePrinter.print()
 * */

public class Main
{
    public static void main(String[] args) {
        Printer printer = new UpperCaseDecorator(new LoggingDecorator(new ConsolePrinter()));

        printer.print("Hello World");
    }
}
