package stevejobs;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test81
{
	public static void main(String[] args) throws Exception
	{
		//Get mobile number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a mobile number");
		String x=sc.nextLine();
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Details of ARD1 and app under testing
		DesiredCapabilities dc1=new DesiredCapabilities();
		dc1.setCapability(CapabilityType.BROWSER_NAME,"");
		dc1.setCapability("deviceName","4200e6519aac84b9");
		dc1.setCapability("platformName","android");
		dc1.setCapability("platformVersion","7.1.1");
		dc1.setCapability("appPackage",
				          "com.samsung.android.contacts");
		dc1.setCapability("appActivity",
				         "com.android.dialer.DialtactsActivity");
		//Create driver object to launch app in ARD1
		AndroidDriver driver1;
		while(2>1)
		{
			try
			{
				driver1=new AndroidDriver(u,dc1);
				break; //terminate from loop
			}
			catch(Exception ex)
			{
			}	
		}
		//Details of ARD2 and any default app
		DesiredCapabilities dc2=new DesiredCapabilities();
		dc2.setCapability(CapabilityType.BROWSER_NAME,"");
		dc2.setCapability("deviceName","228804b77d63");
		dc2.setCapability("platformName","android");
		dc2.setCapability("platformVersion","6.0.1");
		dc2.setCapability("appPackage","x.x.x");
		dc2.setCapability("appActivity","x.x.x.Activity");
		//Create driver object to launch app in ARD2
		AndroidDriver driver2;
		while(2>1)
		{
			try
			{
				driver2=new AndroidDriver(u,dc2);
				break; //terminate from loop
			}
			catch(Exception ex)
			{
			}	
		}
		//dial number and activate call in ARD1
		try
		{
			driver1.manage().timeouts().implicitlyWait(10,
					               TimeUnit.SECONDS);
			for(int i=0;i<x.length();i++)
			{
				char d=x.charAt(i);
				driver1.findElement(By.xpath(
				"//*[@class='android.widget.TextView'][@text='"+d+"'][@index='0']")).click();
			}
			driver1.findElement(By.xpath(
					"//*[@content-desc='Call'][@index='0']")).click();
			WebDriverWait w1=new WebDriverWait(driver1,100);
			w1.until(ExpectedConditions.visibilityOf(
				driver1.findElementByAndroidUIAutomator(
				"new UiSelector().description(\"End call\")")));
			//Lift the call in ARD2
			TouchAction ta=new TouchAction(driver2);
			ta.press(375,1150).moveTo(0,-300).release().perform();
			driver2.manage().timeouts().implicitlyWait(100,
					                             TimeUnit.SECONDS);
			driver2.findElement(By.xpath(
					"//*[@content-desc='End'][@index='1']")).click();
			//Get and display call cost value in ARD1
			WebDriverWait w2=new WebDriverWait(driver1,100);
			w2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@resource-id='android:id/message']")));
			String m=driver1.findElement(By.xpath(
				"//*[@resource-id='android:id/message']"))
				                    .getAttribute("text");
			System.out.println(m);
			driver1.findElement(By.xpath("//*[@text='OK']")).click();
			//Close apps in ARD1 and ARD2
			driver1.closeApp();
			driver2.closeApp();
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
