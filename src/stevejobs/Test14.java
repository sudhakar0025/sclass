package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test14 
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
		//Collect all images
		List<WebElement> l=
				     driver.findElements(By.xpath(
				    	   "(//img)|(//input[@type='image'])"));
		System.out.println(l.size());
		int vcount=0;
		int ivcount=0;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).isDisplayed())
			{
				vcount++;
			}
			else
			{
				ivcount++;
			}
		}
		System.out.println(
				"visible images count is "+vcount);
		System.out.println(
				"Invisible images count is "+ivcount);
		//Close site
		driver.close();
	}
}







