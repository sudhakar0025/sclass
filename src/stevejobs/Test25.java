package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test25
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
		//Get items in a drop-down
		WebElement e=driver.findElement(By.name("nights"));    
		Select s=new Select(e);
		int x=s.getOptions().size();
		System.out.println("Count of items is "+x);
		for(int i=0;i<x;i++)
		{
			System.out.println(s.getOptions().get(i).getText());
		}
		//close site
		driver.close();
	}
}






