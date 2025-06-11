package designPatterns.creational.prototype;

public class Main {
	public static void main(String[] args) {
		Circle original = new Circle(10, "red");
		Circle copy = original.clone();
		System.out.println(copy);
	}
}
