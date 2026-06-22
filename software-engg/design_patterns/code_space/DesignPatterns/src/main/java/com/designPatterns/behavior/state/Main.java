package com.designPatterns.behavior.state;

/**
 *  Fan turned to Low
    Fan turned to High
	Fan turned to Low
	Fan turned Off
 * 
 * */

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.turnUp();   // Low
        fan.turnUp();   // High
        fan.turnDown(); // Low
        fan.turnDown(); // Off
    }
}
