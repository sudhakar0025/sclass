package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test38 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
            	       "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
			"https://semantic-ui.com/modules/dropdown.html");         
		driver.manage().window().maximize();
		Thread.sleep(5000); 
		//Scroll to bottom
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(
			"window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		//Scroll to top
		js.executeScript(
			"window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(5000);
		//Scroll to element
		WebElement el=driver.findElement(By.xpath(
                                 "(//*[@class='search'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();",el);
		Thread.sleep(5000);
	}

}
