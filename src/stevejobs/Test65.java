package stevejobs;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test65
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
			//Provide device and app details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"");
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","7.1.1");
			dc.setCapability("locationServicesEnabled",true);
			dc.setCapability("locationServicesAuthorized",true);
			dc.setCapability("appPackage",
					          "com.google.android.apps.maps");
			dc.setCapability("appActivity",
					     "com.google.android.maps.MapsActivity");
			//Create driver object to launch app
			AndroidDriver driver=new AndroidDriver(u,dc);
			Thread.sleep(30000);
			//Set location to Bengaluru
			Location l1=new Location(12.971599,77.594563,2000);
			driver.setLocation(l1);
			Thread.sleep(20000);
			//Set location to Vijayawada
			Location l2=new Location(16.506174,80.648015,2000);
			driver.setLocation(l2);
			Thread.sleep(20000);
			driver.resetApp();
			Thread.sleep(20000);
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
