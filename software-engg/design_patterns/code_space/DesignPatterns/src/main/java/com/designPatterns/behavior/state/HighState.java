package com.designPatterns.behavior.state;

public class HighState implements FanState {
    public void turnUp(Fan fan) {
        System.out.println("Fan is already at High");
    }
    public void turnDown(Fan fan) {
        fan.setState(new LowState());
        System.out.println("Fan turned to Low");
    }
}
