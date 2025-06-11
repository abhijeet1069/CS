package designPatterns.creational.abstractFactory;

public class WindowsButton implements Button{

	@Override
	public void paint() {
		System.out.println("Rendering a Windows-style button.");
	}
}
