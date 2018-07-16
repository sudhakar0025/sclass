package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test73
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Provide device and app details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("locationServicesEnabled",true);
		dc.setCapability("locationServicesAuthorized",true);
		dc.setCapability("appPackage","com.google.android.apps.maps");
		dc.setCapability("appActivity","com.google.android.maps.MapsActivity");
		//Create driver object to launch app
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
		Connection c=driver.getConnection();
		if(c.compareTo(Connection.AIRPLANE)==0)
		{
			System.out.println("AIRPLANE is ON");
		}
		else
		{
			System.out.println("AIRPLANE is OFF");
		}
		if(c.compareTo(Connection.DATA)==0)
		{
			System.out.println("DATA is ON");
		}
		else
		{
			System.out.println("DATA is OFF");
		}
		if(c.compareTo(Connection.WIFI)==0)
		{
			System.out.println("WIFI is ON");
		}
		else
		{
			System.out.println("WIFI is OFF");
			//driver.setConnection(Connection.WIFI);
		}
		//Close app 
		driver.closeApp();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
