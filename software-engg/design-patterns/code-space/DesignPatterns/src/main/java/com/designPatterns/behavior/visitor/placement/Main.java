package com.designPatterns.behavior.visitor.placement;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
            new Student("Alice", 8.5),
            new Student("Bob", 7.2),
            new Student("Charlie", 9.1)
        );

        College college = new College(studentList);
        CompanyHRVisitor hrVisitor = new CompanyHRVisitor();

        college.accept(hrVisitor);

        System.out.println("Selected Students:");
        for (Student s : hrVisitor.getSelectedStudents()) {
            System.out.println(s.getName() + " - Grade: " + s.getGrade());
        }
    }
}

