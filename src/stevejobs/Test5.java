package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5
{
	public static void main(String[] args) throws Exception
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
		   "//*[contains(@src,'android-button.png')]")).click();
		Thread.sleep(5000);
		//Close browser windows
		driver.quit();

	}

}
