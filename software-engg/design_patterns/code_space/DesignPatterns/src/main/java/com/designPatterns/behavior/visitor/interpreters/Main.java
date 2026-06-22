package com.designPatterns.behavior.visitor.interpreters;

public class Main {
    public static void main(String[] args) {
        Expr expr = new AddExpr(
                new NumberExpr(1),
                new NumberExpr(2)
        );
        Interpreter interpreter = new Interpreter();
        int result = expr.accept(interpreter);
        System.out.println(result);
    }
}
