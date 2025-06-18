package com.servion.doctorBot.faq.general.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.servion.doctorBot.util.LogUtil;

public class FAQServiceTest {
	
	@BeforeAll
    static void setup() {
        LogUtil.logInfo("======= Starting FAQServiceTest in DoctorBot Test Suite =======");
    }
	
	@Test
	void testFAQGetWorkingHours() {
		FAQService faq = new FAQService("faq.json");
		assertEquals("Our clinic is open from 9 AM to 6 PM, Monday to Saturday",faq.getWorkingHours());
	}
	
	@Test
	void testFAQGetFees() {
		FAQService faq = new FAQService("faq.json");
		assertTrue(faq.getFees().contains("The consultation fee is ₹500 for general consultation"));
	}
	
	@Test
	void testFAQGetDoctor() {
		FAQService faq = new FAQService("faq.json");
		assertTrue(faq.getDoctor().get(0).contains("Dr Ravi, Cardiologist"));
		assertTrue(faq.getDoctor().get(1).contains("Dr Mehta, Dentist"));
	}

	@Test
	void testFAQServiceWhenNoFilePresent() {
		try {
			new FAQService("nonexistent.json");
		}
		catch(Exception e) {
			LogUtil.logError(e);
			assertTrue(e.getMessage().contains("File not found"));
		}
	}

	@Test
	void testFAQServiceWhenFileHasSyntaxErrors() {
		try {
			new FAQService("faq/general/bad-faq.json");	
		}
		catch(Exception e) {
			LogUtil.logError(e);
			LogUtil.logErrorDetails(e);
			assertTrue(e.getMessage().contains("Unrecognized field \"topic12\" "));
		}
	}

	@Test
	void testFAQServiceWithNoWorkingHoursTag() {
		try {
			FAQService faq = new FAQService("faq/general/bad-faq-with-noworkinghours.json");
			faq.getWorkingHours();
		}
		catch(Exception e) {
			LogUtil.logError(e);
			assertTrue(e.getMessage().contains("'working_hours' not found in"));
		}
	}

	
}
