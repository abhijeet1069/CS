package com.satyam.learningTest.service;

public interface ConfigService {
	String getServerIP();
    int getServerPort();
    String getServerName();
    String getDBHost();
    int getDBPort();
}
