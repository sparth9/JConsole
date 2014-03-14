package org.jconsole;

import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HistoryCommandTest {

	static HistoryCommand hcom = new HistoryCommand();
	JConsole jcon = JConsole.instance();
	
	
	@Before
	public void setup() {
		hcom.setConsole(jcon);
		runSomeCommands();
	}
	
	public void runSomeCommands() {
		LSCommand lsCom = new LSCommand();
		HelpCommand hCom = new HelpCommand();
		PWDCommand pwdCom = new PWDCommand();
		hCom.setConsole(jcon);
		pwdCom.setConsole(jcon);
		jcon.processLine("pwd");
		jcon.processLine("help");
		String[] args = null;
		try {
			pwdCom.execute(args);
		} catch (CommandFailedException e) {
			e.printStackTrace();
		}
		try {
			hCom.execute(args);
		} catch (CommandFailedException e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void CurDir()
	{
		try {
			String [] args1=null;
			//pcom.execute(args1);
			//String output=outContent.toString();
			//Assert.assertTrue(output.contains(myDir));
			} catch (CommandFailedException e) {
			e.printStackTrace();
			fail("Exception was thrown");
		}
		//outContent.reset();
	}*/
	
	@Test
	public void testHistoryCommand() {
		try {
			String[] args = new String[1];
			args[0] = "1";
			hcom.execute(args);
			List h = jcon.getCommandHistory();
			List<String> commandList = new ArrayList<String>();
			for(int i=0;i<h.size();i++) {
				commandList.add(h.get(i).toString());
			}
			String top = commandList.get(0);
			Assert.assertEquals(top, "pwd");
		}catch (CommandFailedException e) {
			e.printStackTrace();
			fail("Exception was thrown");
		}
	}
}
