package com.designPatterns.behavior.visitor.interpreters;

public class AddExpr implements Expr{
    Expr left;
    Expr right;

    AddExpr(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitAdd(this);
    }
}
