package com.designPatterns.behavior.state;

public class Fan {
    private FanState state;

    public Fan() {
        state = new OffState();
    }

    public void setState(FanState state) {
        this.state = state;
    }

    public void turnUp() {
        state.turnUp(this); //this is the fan object
    }

    public void turnDown() {
        state.turnDown(this);
    }
}
