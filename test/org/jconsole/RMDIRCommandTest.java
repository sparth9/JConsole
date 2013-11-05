package org.jconsole;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RMDIRCommandTest {
	static String myDir = System.getProperty("user.dir");
	RMDIRCommand rmCom = new RMDIRCommand();
	
	@Before
	public void setup() throws Exception{
		JConsole jcon=JConsole.instance();
		jcon.setCurrentDir(myDir);
		rmCom.setConsole(jcon);
		SetClassPath.main(null);
	}
	
	@Test
	public void TestExecuteNullInput()			//mkdir given with null argument 
	{
		RMDIRCommand rm =new RMDIRCommand();
		String [] args1= new String[0];
		try {
			rm.execute(args1);
		} catch (CommandFailedException e) {
			e.printStackTrace();
			fail("Exception was thrown");
		}
	}
}
