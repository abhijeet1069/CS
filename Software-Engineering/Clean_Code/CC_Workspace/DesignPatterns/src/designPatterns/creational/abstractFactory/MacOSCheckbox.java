package designPatterns.creational.abstractFactory;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS-style checkbox.");
    }
}