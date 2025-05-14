package tester;

import org.junit.jupiter.api.Test;

import com.satyam.learningTest.service.ConfigService;
import com.satyam.learningTest.util.LogUtil;

public class TestLog4J {
static ConfigService config1;
	
    @Test
    public void isLogGenerating(){
        LogUtil.logInfo("Tests executed");
    }
}
