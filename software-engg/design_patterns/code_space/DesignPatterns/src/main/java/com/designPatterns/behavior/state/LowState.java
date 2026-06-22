package com.designPatterns.behavior.state;

public class LowState implements FanState {
    public void turnUp(Fan fan) {
        fan.setState(new HighState());
        System.out.println("Fan turned to High");
    }
    public void turnDown(Fan fan) {
        fan.setState(new OffState());
        System.out.println("Fan turned Off");
    }
}
