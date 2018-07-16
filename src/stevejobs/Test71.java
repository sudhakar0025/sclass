package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test71
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
		//getSupportedPerformanceDataTypes()
		List<String> pl=driver.getSupportedPerformanceDataTypes();
		for(int i=0;i<pl.size();i++)
		{
			System.out.print(pl.get(i)+"\t");
		}
		System.out.println();
		//getPerformanceData()
		System.out.println("CPU information:");
		List<List<Object>> ci=driver.getPerformanceData(
							"com.google.android.apps.maps",
							"cpuinfo",10000);
		for(int i=0;i<ci.size();i++)
		{
			for(int j=0;j<ci.get(i).size();j++)
			{
				try
				{
					System.out.print(ci.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.print(0);
				}
			}
			System.out.println("");
		}
		System.out.println("memory information:");
		List<List<Object>> mi=driver.getPerformanceData(
						"com.google.android.apps.maps","memoryinfo",10000);
		for(int i=0;i<mi.size();i++)
		{
			for(int j=0;j<mi.get(i).size();j++)
			{
				try
				{
					System.out.print(mi.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.print(0);
				}
			}
			System.out.println("");
		}
		System.out.println("battery information:");
		List<List<Object>> bi=driver.getPerformanceData(
								"com.google.android.apps.maps","batteryinfo",1000);
		for(int i=0;i<bi.size();i++)
		{
			for(int j=0;j<bi.get(i).size();j++)
			{
				try
				{
					System.out.print(bi.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.print(0);
				}
			}
			System.out.println("");
		}
		System.out.println("network information:");
		List<List<Object>> ni=driver.getPerformanceData(
								"com.google.android.apps.maps","networkinfo",1000);
		for(int i=0;i<ni.size();i++)
		{
			for(int j=0;j<ni.get(i).size();j++)
			{
				try
				{
					System.out.print(ni.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.print(0);
				}
			}
			System.out.println("");
		}
		//close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
