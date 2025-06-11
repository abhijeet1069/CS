package com.servion.doctorBot.util;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servion.doctorBot.exception.ConfigLoadException;

public class JsonReader<T>{
	
	private String path;
	private Class<T> clazz;
	
	JsonReader(String path, Class<T> clazz){
		this.path = path;
		this.clazz = clazz;
	}
	
	public T readJSON() {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
			ObjectMapper mapper = new ObjectMapper();
            if (inputStream == null) {
                throw new ConfigLoadException("File not found: " + path);
            }

            return mapper.readValue(inputStream, clazz);
		}
		catch (JsonParseException e) {
            throw new ConfigLoadException(
                String.format(
                    "JSON syntax error in %s at line %d, column %d: %s",
                    path,
                    e.getLocation().getLineNr(),
                    e.getLocation().getColumnNr(),
                    e.getOriginalMessage()
                ),
                e
            );

        } catch (IOException e) {
            throw new ConfigLoadException("Error reading config file: " + path, e);

        } catch (Exception e) {
            throw new ConfigLoadException("Unexpected error: " + e.getMessage(), e);
        }
	}
}
