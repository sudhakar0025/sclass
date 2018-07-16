package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test68
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
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity",
				           "com.android.calculator2.Calculator");
		//Create driver object to launch app in AVD
		AndroidDriver driver;
		while(2>1)  //infinite loop
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
		//Automate elements 9+5=
		try
		{
			driver.manage().timeouts().implicitlyWait(100,
					                             TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@text='9']")).click();
			driver.findElement(By.xpath("//*[@content-desc='plus']"))
			                                                .click();
			driver.findElement(By.xpath("//*[@text='5']")).click();
			driver.findElement(By.xpath(
					"//*[@content-desc='equals']")).click();
			String x=driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText']"))
					.getAttribute("text");
			System.out.println(x);
			//Close app
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
