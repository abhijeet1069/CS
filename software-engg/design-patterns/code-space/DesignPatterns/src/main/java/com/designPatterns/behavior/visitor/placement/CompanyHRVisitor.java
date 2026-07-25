package com.designPatterns.behavior.visitor.placement;

import java.util.ArrayList;
import java.util.List;

class CompanyHRVisitor implements Visitor {
    private List<Student> selectedStudents = new ArrayList<>();

    @Override
    public void visit(Student student) {
        if (student.getGrade() > 8.0) {
            selectedStudents.add(student);
        }
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }
}
