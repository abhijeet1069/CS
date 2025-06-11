package com.servion.doctorBot.faq.availability.pojo;

import java.util.List;

public class Roster {
	private List<Doctor> doctor;
    private List<Holiday> holidays;
	
    
    public Roster(List<Doctor> doctor, List<Holiday> holidays) {
		this.doctor = doctor;
		this.holidays = holidays;
	}
    
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	public List<Holiday> getHolidays() {
		return holidays;
	}
	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}
    
    
}
