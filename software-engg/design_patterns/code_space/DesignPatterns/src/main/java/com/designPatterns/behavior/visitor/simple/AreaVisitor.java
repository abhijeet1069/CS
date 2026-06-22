package com.designPatterns.behavior.visitor.simple;

public class AreaVisitor implements Visitor<Double>{

    @Override
    public Double visit(Circle circle){
        return Math.PI*circle.radius*circle.radius;
    }

    @Override
    public Double visit(Rectangle rectangle) {
        return (double) (rectangle.width * rectangle.height);
    }
}
