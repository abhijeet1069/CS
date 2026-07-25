package com.designPatterns.behavior.visitor.interpreters;

public class Interpreter implements Visitor<Integer>{

    public Integer visitNumber(NumberExpr expr){
        return expr.value;
    }

    @Override
    public Integer visitAdd(AddExpr expr) {
        int left = expr.left.accept(this);
        int right = expr.right.accept(this);
        return left+right;
    }
}
