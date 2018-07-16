package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test12
{
	public static void main(String[] args) throws Exception
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.gmail.com");                      
		Thread.sleep(5000);
		//validation
		try
		{
			if(driver.findElement(By.name("identifier"))
					                     .isDisplayed())
			{
				System.out.println("Test passed");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Test failed");
		}
		//close site
		driver.close();
	}
}
