package designPatterns.creational.abstractFactory;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS-style button.");
    }
}
