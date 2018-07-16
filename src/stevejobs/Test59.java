package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test59
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec(
		"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		String x=sc.nextLine();
		System.out.println("Enter input2");
		String y=sc.nextLine();
		//Provide device details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		//Provide app details
		dc.setCapability("appPackage",
				"com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity",
				"com.sec.android.app.popupcalculator.Calculator");
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
		//click +
		driver.findElement(By.xpath("//*[@content-desc='Plus']"))
														 .click();
		Thread.sleep(5000);
		//Enter input2
		for(int i=0;i<y.length();i++)
		{
			char c=y.charAt(i);
		  driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
			Thread.sleep(5000);
		}
		//click =
		driver.findElement(By.xpath("//*[@content-desc='Equal']"))
		                                                  .click();
		Thread.sleep(5000);
		//Get output
		String z=driver.findElement(By.xpath(
				        "//*[@class='android.widget.EditText']"))
				        .getAttribute("text");
		Thread.sleep(5000);
		//Validate output
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=Integer.parseInt(z);
		if(c==a+b)
		{
			System.out.println("Addition test passed");
		}
		else
		{
			System.out.println("Addition test failed");
			DateFormat df=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		    Date d=new Date();
		    String imagename=df.format(d); //today date with time
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("E:\\batch237\\"+imagename+".png");
			FileUtils.copyFile(src,dest);
		}
		//close app
		driver.closeApp();
		Thread.sleep(5000);
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
