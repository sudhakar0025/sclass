package stevejobs;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test63
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		try
		{
			//Provide device details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"");
			dc.setCapability("deviceName","emulator-5554");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","4.2.2");
			//Provide app details
			dc.setCapability("appPackage",
					     "com.android.calculator2");
			dc.setCapability("appActivity",
				         "com.android.calculator2.Calculator");
			//Launch app
			AndroidDriver driver=new AndroidDriver(u,dc);
			Thread.sleep(10000);
			String x=driver.getOrientation().name();
			System.out.println(x);
			if(x.equals("PORTRAIT"))
			{
				driver.rotate(ScreenOrientation.LANDSCAPE);
			}
			Thread.sleep(10000);
			driver.lockDevice();
			Thread.sleep(10000);
			if(driver.isLocked())
			{
				System.out.println("Locked");
				driver.unlockDevice();
			}
			//close app
			driver.closeApp();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//Stop and Close Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	}
}
