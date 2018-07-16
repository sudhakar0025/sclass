package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test82
{
	public static void main(String[] args) throws Exception
	{
		//Get platform
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter platform");
		String p=sc.nextLine();
		WebDriver driver;
		if(p.equals("computer"))
		{
			//Run chromedriver.exe to get chrome browser
			System.setProperty("webdriver.chrome.driver",
					        "E:\\batch237\\chromedriver.exe");
			//Open site in chrome browser
			driver=new ChromeDriver();
			Thread.sleep(5000);
		}
		else
		{
			//Start appium server
			Runtime.getRuntime().exec(
			"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Details of ARD
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","7.1.1");
			//Create driver object and launch chrome browser
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
			
		}
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Enter input
		driver.findElement(By.name("q")).sendKeys("kalam",Keys.ENTER);
		Thread.sleep(5000);
		//close site
		driver.close();
		if(p.equals("mobile"))
		{
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
	}

}
