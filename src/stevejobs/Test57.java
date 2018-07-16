package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test57
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Provide device details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		//Provide app details
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity",
				         "com.android.calculator2.Calculator");
		//Launch app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(5000);
		//Automate 9+5=
		driver.findElement(By.xpath("//*[@text='9']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@content-desc='plus']"))
														.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='5']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@content-desc='equals']"))  
														.click();
		Thread.sleep(5000);
		String x=driver.findElement(By.xpath(
				      "//*[@class='android.widget.EditText']"))
				      .getAttribute("text");
		System.out.println(x);
		Thread.sleep(5000);
		//Close app in AVD
		driver.closeApp();
		Thread.sleep(5000);
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}







