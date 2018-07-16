package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test33
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
            	"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");         
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement el=driver.findElement(By.xpath(
				                "(//*[@class='search'])[2]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",el);
		Thread.sleep(5000);
		//Select multiple items
		WebElement e=driver.findElement(By.xpath(
		 "//*[@class='ui fluid dropdown selection multiple']"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		a.sendKeys("a").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		a.sendKeys("h").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//De-select 2nd item in drop-down
		//driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple active visible']/child::a[2]/child::i")).click();
		//De-select all
		List<WebElement> l=driver.findElements(By.xpath("//*[@class='ui fluid dropdown selection multiple active visible']/child::a"));
		System.out.println("Selected items count is "+l.size());
		for(int i=0;i<l.size();i++)
		{
			l.get(i).findElement(By.tagName("i")).click();
		}

	}

}





