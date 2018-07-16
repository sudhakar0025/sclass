package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test23
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
	                  "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.mercurytravels.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Check drop-down
		WebElement e=driver.findElement(By.name("nights"));    
		Select s=new Select(e);
		if(s.isMultiple())
		{
			System.out.println("Multi-select");
		}
		else
		{
			System.out.println("Single-select");
		}
		//Close site
		driver.close();
	}
}
