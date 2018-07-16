package stevejobs;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
public class Test48
{
	public static void main(String[] args) throws Exception
	{
		//Launch window based software
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//Enter input1
		StringSelection x=new StringSelection("128");
		Toolkit.getDefaultToolkit().getSystemClipboard()
		                            .setContents(x,null);
		Robot r=new Robot();
		if(System.getProperty("os.name").contains("Windows"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			r.keyPress(KeyEvent.VK_META);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_META);
			Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
		}
		else
		{
			System.out.println("Unknown OS");
			System.exit(0);
		}
		//Click plus button
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(5000);
		//Enter input2
		StringSelection y=new StringSelection("234");
		Toolkit.getDefaultToolkit().getSystemClipboard()
		                            .setContents(y,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//Click equals button
		r.keyPress(KeyEvent.VK_EQUALS);
		r.keyRelease(KeyEvent.VK_EQUALS);
		Thread.sleep(5000);
		//Get output
		r.keyPress(KeyEvent.VK_CONTEXT_MENU);
		r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String z=(String) Toolkit.getDefaultToolkit()
		.getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println(z);
		//Close window
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);	
	}
}






