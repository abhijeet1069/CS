package com.satyam.learningTest.util;

public class ConfigLoadException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ConfigLoadException(String message) {
        super(message);
    }

    public ConfigLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigLoadException(Throwable cause) {
        super(cause);
    }
}

