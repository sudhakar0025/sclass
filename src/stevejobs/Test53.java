package stevejobs;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
public class Test53
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser(SWD)
		System.setProperty("webdriver.chrome.driver",
	     	       "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site(SWD)
		driver.get("http://www.millionclouds.com");                  
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Automate non-html elements(SikuliX)
		Screen s=new Screen();
		s.click("fp.png");
		Thread.sleep(5000);
		s.click("allow.png");
		Thread.sleep(5000);
		while(2>1) //infinite loop
		{
			if(s.exists("login.png")!=null)
			{
				s.click("login.png");
				break; //terminate from infinite loop
			}
		}
		Thread.sleep(5000);
		s.type("uid.png","mindq");
		s.type("pwd.png","sachin");
		s.click("signin.png");
		Thread.sleep(5000);
		Settings.OcrTextSearch=true;
		Settings.OcrTextRead=true;
		Region r=new Region(268,350,256,40);
		String x=r.text();
		System.out.println(x);
		//Close site(SikuliX)
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyUp(Key.F4);
		s.keyUp(Key.ALT);
	}
}


