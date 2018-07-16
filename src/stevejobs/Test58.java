package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test58
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		String x=sc.nextLine();
		System.out.println("Enter input2");
		String y=sc.nextLine();
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
		//Enter input1
		for(int i=0;i<x.length();i++)
		{
			char c=x.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
			Thread.sleep(5000);
		}
		driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
		Thread.sleep(5000);
		//Enter input2
		for(int i=0;i<y.length();i++)
		{
			char c=y.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
			Thread.sleep(5000);
		}
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		Thread.sleep(5000);
		String z=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		System.out.println(z);
		driver.closeApp();
		Thread.sleep(5000);
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
