package org.jconsole;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MKDIRCommandTest {

	static String myDir = System.getProperty("user.dir");
	MKDIRCommand mkCom = new MKDIRCommand();
	
	@Before
	public void setup(){
		JConsole jcon=JConsole.instance();
		jcon.setCurrentDir(myDir);
		mkCom.setConsole(jcon);
	}
	
	@Test
	public void TestExecuteNullInput()			//mkdir given with null argument 
	{
		MKDIRCommand mc=new MKDIRCommand();
		String [] args1=null;
		try {
			mc.execute(args1);
			fail("Exception was not thrown");
		} catch (CommandFailedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestExecuteValidInput()
	{
		MKDIRCommand mc=new MKDIRCommand();
		String [] args2={"testResource"};
		try {
			mc.execute(args2);
		} catch (CommandFailedException e) {
			fail("Exception was thrown");
			e.printStackTrace();
		}
	}

}
