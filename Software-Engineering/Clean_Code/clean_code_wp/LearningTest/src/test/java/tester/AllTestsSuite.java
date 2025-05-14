package tester;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    TestYAMLConfigServiceHappyCase.class,
    TestYAMLConfigServiceUnHappyCase.class,
    TestLog4J.class
})
public class AllTestsSuite {
    // This class remains empty. It is used only as a holder for the above annotations.
}

