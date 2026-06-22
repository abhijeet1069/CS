package com.designPatterns.behavior.observer;

public class NewsChannelB implements Observer {
    public void update(String news) {
    	 System.out.println("Channel B received: " + news);
    }
}
