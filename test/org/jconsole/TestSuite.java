package org.jconsole;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	LSCommandTest.class,
	CDCommandTest.class,
	CPCommandTest.class,
	MKDIRCommandTest.class
})

public class TestSuite {

}