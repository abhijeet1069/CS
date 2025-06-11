package tester;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.satyam.learningTest.service.YAMLConfigService;
import com.satyam.learningTest.util.ConfigLoadException;
import com.satyam.learningTest.util.LogUtil;

public class TestYAMLConfigServiceUnHappyCase {

	@Test
	void loadWhenFileNotFound() {
		String configFile = "/non_existent_config.yml";
		ConfigLoadException exception = assertThrows(
		        ConfigLoadException.class,
		        () -> new YAMLConfigService(configFile)
		    );
		LogUtil.logError(exception);
	    assertTrue(exception.getMessage().contains("File not found at path:"));
	    
	}
	
	@Test
	void loadWhenFileIsAmbiguous() {
		String configFile = "$$";
		ConfigLoadException exception = assertThrows(
		        ConfigLoadException.class,
		        () -> new YAMLConfigService(configFile)
		    );
		LogUtil.logError(exception);
	    assertTrue(exception.getMessage().contains("File not found at path:"));
	}
	
	@Test
	void loadWhenFileIsNull() {
		String configFile = null;
		ConfigLoadException exception = assertThrows(
		        ConfigLoadException.class,
		        () -> new YAMLConfigService(configFile)
		    );
		LogUtil.logError(exception);
	    assertTrue(exception.getMessage().contains("Configuration path must not be null"));
	}
	
	@Test
	void loadWhenFileIsEmpty1() {
		String configFile = "";
		ConfigLoadException exception = assertThrows(
		        ConfigLoadException.class,
		        () -> new YAMLConfigService(configFile)
		    );
		LogUtil.logError(exception);
	    assertTrue(exception.getMessage().contains("Configuration path must not be empty"));
	}
	
	@Test
	void loadWhenFileIsEmpty2() {
		String configFile = " ";
		ConfigLoadException exception = assertThrows(
		        ConfigLoadException.class,
		        () -> new YAMLConfigService(configFile)
		    );
		LogUtil.logError(exception);
	    assertTrue(exception.getMessage().contains("Configuration path must not be empty"));
	}
	
	@Test
	void loadWhenFileSyntaxIsIncorrect() {
		String configFile = "/bad_config.yml";
		ConfigLoadException exception = assertThrows(
		        ConfigLoadException.class,
		        () -> new YAMLConfigService(configFile)
		    );
		LogUtil.logError(exception);
	    assertTrue(exception.getMessage().contains("YAML syntax error in file"));
	}
}
