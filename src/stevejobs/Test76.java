package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test76
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
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
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
		//dial number and activate call
		try
		{
			driver.manage().timeouts().implicitlyWait(100,
					                              TimeUnit.SECONDS);
			for(int i=0;i<x.length();i++)
			{
				char d=x.charAt(i);
				driver.findElement(By.xpath(
		                "//*[@class='android.widget.TextView'][@text='"+d+"'][@index='0']")).click();
			}
			driver.findElement(By.xpath(
				"//*[@content-desc='Call'][@index='0']")).click();
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOf(
					  driver.findElementByAndroidUIAutomator(
				     "new UiSelector().description(\"End call\")")));
			//Take screen shot
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("toastedmsg.png");
			FileUtils.copyFile(src,dest);
			//Click End Call
			driver.findElementByAndroidUIAutomator(
				   "new UiSelector().description(\"End call\")").click();
			driver.closeApp();
			//Get toasted message (3.0 is stable for tess4j)
			File tessDataFolder=
					        LoadLibs.extractTessResources("tessdata");
			Tesseract obj=new Tesseract();
			obj.setDatapath(tessDataFolder.getAbsolutePath());
			String result=obj.doOCR(dest);
			Thread.sleep(10000);
			System.out.println(result);
			if(result.contains("Conditional Call for"))
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test failed");
			}
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
