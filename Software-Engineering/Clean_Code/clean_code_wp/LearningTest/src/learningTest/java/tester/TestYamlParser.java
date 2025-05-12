package tester;
/*
*  TODO : Read from a YML file
*  TODO: Log in a text file
* */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import testee.pojo.Config;
import testee.pojo.YamlParser;

public class TestYamlParser {

    static Config config;

    @BeforeAll
    static void setup(){
        config = YamlParser.getConfig();
    }

    @Test
    public void checkServerIP(){
        assertEquals("192.169.29.20",config.getServer().getIP());
    }

    @Test
    public void checkServerPort(){
        assertEquals(8080,config.getServer().getPort());
    }

    @Test
    public void checkServerName(){
        assertEquals("MyApp",config.getServer().getName());
    }

    @Test
    public void checkDBHost(){
        assertEquals("localhost",config.getDatabase().getHost());
    }

    @Test
    public void checkDBPort(){
        assertEquals(5432,config.getDatabase().getPort());
    }
}
