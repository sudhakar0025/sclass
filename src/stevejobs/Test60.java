package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test60
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
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		try
		{
			//Details of ARD and AUT(app under testing)
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"");
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","7.1.1");
			dc.setCapability("appPackage","com.samsung.android.contacts");
			dc.setCapability("appActivity",
					              "com.android.dialer.DialtactsActivity");
			//Create driver object to launch app in ARD
			AndroidDriver driver=new AndroidDriver(u,dc);
			Thread.sleep(10000);
			//dial a number
			for(int i=0;i<x.length();i++)
			{
				char d=x.charAt(i);
				driver.findElement(By.xpath(
						     "//*[@text='"+d+"'][@index='0']")).click();
				Thread.sleep(5000);
			}
			driver.findElement(By.xpath(
			  "//*[@content-desc='Call'][@index='0']")).click();
			Thread.sleep(10000);
			driver.findElementByAndroidUIAutomator(
			     "new UiSelector().description(\"End call\")").click();
			//close app 
			driver.closeApp();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop and close appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
