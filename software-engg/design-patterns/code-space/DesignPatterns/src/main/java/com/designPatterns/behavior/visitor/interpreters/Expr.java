package com.designPatterns.behavior.visitor.interpreters;

public interface Expr {
    <R> R accept(Visitor<R> visitor);
}
