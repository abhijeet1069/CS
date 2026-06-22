package com.designPatterns.behavior.visitor.simple;

public interface Shape {
    <T> T accept(Visitor<T> visitor);
}
