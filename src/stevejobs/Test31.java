package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test31
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
            	"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");         
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Fill auto-complete/cache element
		WebElement e=driver.findElement(By.name("q"));          
		Actions a=new Actions(driver);
		a.sendKeys(e,"kalam").build().perform();
		Thread.sleep(5000);
		//Automate suggestions list for "kalam quotes"
		while(2>1)  //infinite loop
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
			String x=driver.findElement(By.name("q"))
					                  .getAttribute("value");
			if(x.equals("kalam quotes"))
			{
				break; //to terminate from current loop
			}
		}

	}

}




