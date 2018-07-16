package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test61
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
			//Provide Calculator app details
			dc.setCapability("appPackage",
				"com.sec.android.app.popupcalculator");
			dc.setCapability("appActivity",
				"com.sec.android.app.popupcalculator.Calculator");
			//Launch calculator app by creating driver object
			AndroidDriver driver=new AndroidDriver(u,dc);
			Thread.sleep(10000);
			//Goto Home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(10000);
			//Goto Apps list
			driver.findElement(By.xpath("//*[@text='Apps'][@index='2']")).click();
			Thread.sleep(10000);
			//Click on Messages
			driver.findElement(By.xpath("//*[contains(@content-desc,'Messages')][@index='2']")).click();
			Thread.sleep(10000);
			//Click on search box
			driver.findElement(By.xpath("//*[contains(@text,'Search')][@index='0']")).click();
			Thread.sleep(10000);
			//Hide keyboard
			if(driver.isKeyboardShown())
			{
				driver.hideKeyboard();
			}
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[contains(@text,'Search')][@index='0']")).sendKeys("Kalam");
			Thread.sleep(10000);
			//Goto Home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(10000);
			//launch initial app
			driver.launchApp();
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
