package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test18 
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
		driver.switchTo().activeElement().sendKeys("mindq");

	}

}
