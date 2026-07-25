package com.designPatterns.behavior.visitor.simple;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4,6);

        Visitor areaVisitor = new AreaVisitor();
        circle.accept(areaVisitor);
        rectangle.accept(areaVisitor);
    }
}
