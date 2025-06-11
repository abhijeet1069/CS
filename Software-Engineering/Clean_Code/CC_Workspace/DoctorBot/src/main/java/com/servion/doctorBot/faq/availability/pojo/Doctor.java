package com.servion.doctorBot.faq.availability.pojo;

import java.util.List;

public class Doctor {
    private String doctor_name;
    private List<GeneralTiming> general_timing;
    private List<Leave> leaves;

    // Getters and Setters
    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public List<GeneralTiming> getGeneral_timing() {
        return general_timing;
    }

    public void setGeneral_timing(List<GeneralTiming> general_timing) {
        this.general_timing = general_timing;
    }

    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }
}

