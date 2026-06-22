package com.designPatterns.behavior.visitor.placement;

public class Student implements StudentElement{

	private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
