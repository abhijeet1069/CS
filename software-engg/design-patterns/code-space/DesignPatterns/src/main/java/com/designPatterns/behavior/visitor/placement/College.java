package com.designPatterns.behavior.visitor.placement;

import java.util.List;

public class College {
    private List<Student> students;

    public College(List<Student> students) {
        this.students = students;
    }

    public void accept(Visitor visitor) {
        for (Student s : students) {
            s.accept(visitor);
        }
    }
}

