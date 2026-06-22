package com.designPatterns.behavior.visitor.simple;

public class Rectangle implements Shape{
    int width;
    int height;

    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
