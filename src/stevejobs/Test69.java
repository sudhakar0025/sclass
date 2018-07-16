package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test69
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Launch app in AVD
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("automationName","uiautomator2");
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
		try
		{
			//Automate elements in app screens
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@text='AGREE AND CONTINUE']")).click();
			driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
			driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
			driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
			driver.hideKeyboard();
			String t=driver.findElement(By.xpath("//*[@bounds='[32,176][688,297]']")).getAttribute("text");
			System.out.println(t);
			driver.findElement(By.xpath("//*[@text='phone number']")).sendKeys("9502462822");
			/*driver.findElement(By.xpath("//*[@text='NEXT']")).click();
			driver.findElement(By.xpath("//*[@text='OK']")).click();
			driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
			driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
			driver.findElement(By.xpath("//*[@text='RESTORE']")).click();
			driver.findElement(By.xpath("//*[@text='NEXT']")).click();
			driver.findElement(By.xpath("//*[@text='Type your name here']")).sendKeys("veer");
			driver.findElement(By.xpath("//*[@text='NEXT']")).click();*/
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//Close app 
		driver.closeApp();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
