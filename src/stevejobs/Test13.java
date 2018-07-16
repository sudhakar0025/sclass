package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13
{
	public static void main(String[] args) throws Exception
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.mercurytravels.co.in");                      
		Thread.sleep(5000);
		//Collect all drop-downs
		List<WebElement> dll=
				     driver.findElements(By.tagName("select"));
		int vcount=0;
		int ivcount=0;
		for(int i=0;i<dll.size();i++)
		{
			if(dll.get(i).isDisplayed())
			{
				vcount=vcount+1;
			}
			else
			{
				ivcount=ivcount+1;
			}
		}
		System.out.println(
				"visible drop-downs count is "+vcount);
		System.out.println(
				"Invisible drop-downs count is "+ivcount);
		//close site
		driver.close();
	}
}
