package com.designPatterns.behavior.visitor.interpreters;

public interface Visitor<R> {
    R visitNumber(NumberExpr expr);
    R visitAdd(AddExpr expr);
}
