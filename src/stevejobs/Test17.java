package stevejobs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test17
{
	public static void main(String[] args) throws InterruptedException
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
		           "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
			"http://site21.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Click on google play
		driver.findElement(By.xpath(
				"//*[contains(@src,'android-button.png')]"))
				.click();
		Thread.sleep(5000);
		String x=driver.getWindowHandle();
		System.out.println(x);
		ArrayList<String> y=new ArrayList<String>(
				         driver.getWindowHandles());            
		for(int i=0;i<y.size();i++)
		{
			System.out.println(y.get(i));
		}
	}
}


