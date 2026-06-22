package com.designPatterns.behavior.visitor.simple;

public interface Visitor<T> {
    T visit(Circle circle);
    T visit(Rectangle rectangle);
}
