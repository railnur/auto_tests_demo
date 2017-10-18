package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.processes.EmissionTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmissionTests.class,
})

public class JunitTestSuite {
}