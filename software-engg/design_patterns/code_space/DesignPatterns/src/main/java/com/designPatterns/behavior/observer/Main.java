package com.designPatterns.behavior.observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer channelA = new NewsChannelA();
        Observer channelB = new NewsChannelB();

        agency.addObserver(channelA);
        agency.addObserver(channelB);

        agency.setNews("Breaking News: Observer Pattern Simplified!");
    }
}
