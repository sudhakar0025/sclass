package stevejobs;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test66 
{
	public static void main(String[] args) throws Exception
	{
		//Get mobile number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String x=sc.nextLine();
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		try
		{
			//Provide device and app details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"");
			dc.setCapability("deviceName","emulator-5554");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","4.2.2");
			dc.setCapability("appPackage","com.android.calculator2");
			dc.setCapability("appActivity","com.android.calculator2.Calculator");
			//Create driver object to launch app in AVD
			AndroidDriver driver=new AndroidDriver(u,dc);
			Thread.sleep(10000);
			driver.rotate(ScreenOrientation.PORTRAIT);
			Thread.sleep(10000);
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@text='Phone']")).click();
			Thread.sleep(10000);
			for(int i=0;i<x.length();i++)
			{
				String y="";
				char c=x.charAt(i);
				switch(c)
				{
				case '0':
					y="zero";
					break;
				case '1':
					y="one";
					break;
				case '2':
					y="two";
					break;
				case '3':
					y="three";
					break;
					
				case '4':
					y="four";
					break;
					
				case '5':
					y="five";
					break;
				case '6':
					y="six";
					break;
				case '7':
					y="seven";
					break;
				case '8':
					y="eight";
					break;
				case '9':
					y="nine";
					break;	
				}
				driver.findElement(By.xpath("//*[@content-desc='"+y+"']")).click();
				Thread.sleep(5000);
			}
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(10000);
			driver.launchApp();
			Thread.sleep(10000);
			driver.closeApp();
			Thread.sleep(10000);
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
