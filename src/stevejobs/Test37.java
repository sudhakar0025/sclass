package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test37 
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
		//Get all items in div tag drop down to display
		List<WebElement> l=driver.findElements(By.xpath("//*[@class='ui fluid dropdown selection multiple']/div/div"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			js.executeScript("var x=arguments[0].textContent; alert(x);",l.get(i));
			String y=driver.switchTo().alert().getText();
			if(y.charAt(0)=='A')
			{
				System.out.println(y);
			}
			driver.switchTo().alert().dismiss();
		}
		//close site
		driver.close();
		
		

	}

}
