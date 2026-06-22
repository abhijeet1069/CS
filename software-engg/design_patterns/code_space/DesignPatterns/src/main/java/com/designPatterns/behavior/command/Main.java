package com.designPatterns.behavior.command;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();

        Command lightOn = new TurnOnCommand(light);
        Command lightOff = new TurnOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is ON

        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is OFF
    }
}

