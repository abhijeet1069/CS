package com.satyam.creationalPatterns.factoryMethod;

public class Car implements Vehicle{

	@Override
	public void start() {
		System.out.println("Car started");
	}
}
