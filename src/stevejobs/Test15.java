package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Test15
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
		//Do login
		driver.findElement(By.name("username"))
										.sendKeys("9439922064");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		//Validation
		if(ExpectedConditions.alertIsPresent()!=null)
		{
			String x=driver.switchTo().alert().getText();
			if(x.contains("Password"))
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println(
						  "Test failed due to wrong msg");
			}
			driver.switchTo().alert().dismiss();
			Thread.sleep(5000);
		}
		else
		{
			System.out.println("Test failed due to no alert");
		}
		//Close site
		driver.close();
	}
}




