package com.designPatterns.behavior.visitor.simple;

public class Circle implements Shape{
    int radius;

    Circle(int radius){
        this.radius = radius;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
