package com.designPatterns.behavior.visitor.interpreters;

public class NumberExpr implements Expr{

    int value;

    public NumberExpr(int value) {
        this.value = value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitNumber(this);
    }
}
