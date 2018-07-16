package stevejobs;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test77 
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Details of AVD and AUT(app under testing)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.deskclock");
		dc.setCapability("appActivity",
				              "com.android.deskclock.DeskClock");
		//Create driver object to launch app in AVD
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
		try
		{
			driver.manage().timeouts().
			                      implicitlyWait(5,TimeUnit.SECONDS);
			driver.findElement(By.xpath(
					         "//*[@content-desc='Cities']")).click();
			//Perform swipe for required element(city)
			driver.context("NATIVE_APP");
			int w=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			TouchAction ta=new TouchAction(driver);
			//swipe from bottom to top for required city
			int x=(int)(w/2);
			int y=(int)(h*0.9); //near to bottom
			int temp=(int)(h*0.7); //near to top
			while(2>1) //infinite loop
			{
				try
				{
					driver.findElement(By.xpath(
							"//*[@text='Delhi']")).click();
					break; //to terminate from current loop
				}
				catch(Exception ex)
				{
				 ta.press(x,y).moveTo(0,temp-y).release().perform();
				}
			}
			//swipe from top to bottom for required city
			y=(int)(h*0.7); //near to top
			temp=(int)(h*0.9); //near to bottom
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath(
							"//*[@text='Adelaide']")).click();
					break;
				}
				catch(Exception e)
				{
				 ta.press(x,y).moveTo(0,temp-y).release().perform();
				}
			}
			//Back to app home
			driver.pressKeyCode(AndroidKeyCode.BACK);
			//Close app
			driver.closeApp();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
