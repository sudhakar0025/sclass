package stevejobs;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test80
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Details of ARD and AUT(app under testing)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("appPackage",
				                   "com.samsung.android.contacts");
		dc.setCapability("appActivity",
				            "com.android.dialer.DialtactsActivity");
		//Create driver object to launch app in ARD
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break; //terminate from loop
			}
			catch(Exception ex)
			{
			}	
		}
		//Define multiple Touch actions
		WebElement e1=driver.findElement(By.xpath("//*[@text='5']"));
		TouchAction ta1=new TouchAction(driver)
		        				.press(e1).release();
		WebElement e2=driver.findElement(
						                 By.xpath("//*[@text='6']"));
		TouchAction ta2=new TouchAction(driver)
		        				.press(e2).release();
		//Create object to MultiTouchAction to perform
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		Thread.sleep(10000);
		//close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}