package com.designPatterns.behavior.visitor.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaVisitorTest {
    @Test
    public void testVisit() {
        Shape circle = new Circle(1);
        double area = circle.accept(new AreaVisitor());
        assertEquals(3.14,area,0.01);
    }
}