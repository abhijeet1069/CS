package com.designPatterns.behavior.observer;

public class NewsChannelA implements Observer {
    public void update(String news) {
        System.out.println("Channel A received: " + news);
    }
}
