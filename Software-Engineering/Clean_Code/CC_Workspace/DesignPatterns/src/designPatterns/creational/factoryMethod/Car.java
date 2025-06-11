package designPatterns.creational.factoryMethod;

public class Car implements Vehicle{

	@Override
	public void start() {
		System.out.println("Car started");
	}
}
