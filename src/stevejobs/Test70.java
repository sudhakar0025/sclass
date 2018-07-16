package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test70
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
		//getRemoteAddress()
		URL x=driver.getRemoteAddress();
		System.out.println("Appium server url is "+x.getPath());
		System.out.println("Appium server port is "+x.getPort());
		System.out.println(
				"Appium server protocol is "+x.getProtocol());
		//getDeviceTime()
		String y=driver.getDeviceTime();
		System.out.println("Device time is "+y);
		//getPlatformName()
		String w=driver.getPlatformName();
		System.out.println("Platform name is "+w);
		//getDisplayDensity()
		long l=driver.getDisplayDensity();
		System.out.println("Display density is "+l);
		//openNotifications()
		driver.openNotifications();
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				   By.xpath("//*[@text='airtel'][@index='2']")));
		driver.pressKeyCode(AndroidKeyCode.BACK);
		//Close app 
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
