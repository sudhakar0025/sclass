package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test72
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Provide device and app details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("appPackage","com.whatsapp");
		dc.setCapability("appActivity","com.whatsapp.Main");
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
		//get contexts related to app
		Set s=driver.getContextHandles();
		ArrayList<String> al=new ArrayList<String>(s);
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		//get current context
		String x=driver.getContext();
		System.out.println(x);
		//change context
		if(driver.isBrowser())
		{
			driver.context("NATIVE_APP");
		}
		//Stop and Close Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	}
}
