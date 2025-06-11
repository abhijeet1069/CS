package tester;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.satyam.learningTest.service.ConfigService;
import com.satyam.learningTest.service.YAMLConfigService;

public class TestYAMLConfigServiceHappyCase {

	static ConfigService config;
	
    @BeforeAll
    static void setup(){
    	config = new YAMLConfigService("/good_config.yml");
    }

    @Test
    public void checkServerIP(){
        assertEquals("192.169.29.20",config.getServerIP());
    }

    @Test
    public void checkServerPort(){
        assertEquals(8080,config.getServerPort());
    }

    @Test
    public void checkServerName(){
    	assertEquals("MyApp",config.getServerName());
    }

    @Test
    public void checkDBHost(){
        assertEquals("localhost",config.getDBHost());
    }

    @Test
    public void checkDBPort(){
        assertEquals(5432,config.getDBPort());
    }
}
