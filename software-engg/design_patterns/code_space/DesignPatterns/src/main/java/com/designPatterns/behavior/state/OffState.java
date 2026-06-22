package com.designPatterns.behavior.state;

public class OffState implements FanState {
    public void turnUp(Fan fan) {
        fan.setState(new LowState());
        System.out.println("Fan turned to Low");
    }
    public void turnDown(Fan fan) {
        System.out.println("Fan is already Off");
    }
}
