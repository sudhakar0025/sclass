package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test62 
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
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","7.1.1");
			//Provide app details
			dc.setCapability("appPackage",
				"com.sec.android.app.popupcalculator");
			dc.setCapability("appActivity",
				"com.sec.android.app.popupcalculator.Calculator");
			//Launch calculator app by creating driver object
			AndroidDriver driver=new AndroidDriver(u,dc);
			Thread.sleep(10000);
			//Get package and Activity names of opened app
			String x=driver.getCurrentPackage();
			System.out.println(x);
			String y=driver.currentActivity();
			System.out.println(y);
			//Send app to background for 10 seconds
			Duration d=Duration.of(10, ChronoUnit.SECONDS);
			driver.runAppInBackground(d);
			Thread.sleep(10000);
			//Goto Home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(10000);
			//Activate calculator 
			driver.launchApp();
			Thread.sleep(10000);
			//Operate an element and Reset app
			driver.findElement(By.xpath("//*[@text='9']")).click();
			Thread.sleep(5000);
			driver.resetApp();
			Thread.sleep(10000);
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






