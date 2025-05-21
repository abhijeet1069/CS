package com.satyam.creationalPatterns.builder;

public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i9", 32)
                                .setStorage(1000)
                                .setGraphicsCard(true)
                                .build();

        Computer officePC = new Computer.Builder("Intel i5", 16)
                                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}

