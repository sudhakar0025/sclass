package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test43
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
				   "E:\\batch237\\chromedriver.exe");
		//Create object to access that opened browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://angularjs.org");
		Thread.sleep(5000);
		//Fill text-box(developed using AngularJS)
		driver.findElement(By.xpath(
			  "//*[@ng-model='yourName']")).sendKeys("kalam");
		Thread.sleep(5000);
		//Get message
		String x=driver.findElement(By.xpath(
		  "(//*[text()='Name:'])[2]/following-sibling::*[3]"))
			.getText();
		System.out.println(x);
		//close site
		driver.close();

	}

}
