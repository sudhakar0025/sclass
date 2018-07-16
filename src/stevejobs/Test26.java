package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test26
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
		//Collect all drop-downs
		List<WebElement> ddl=
			driver.findElements(By.tagName("select"));
		//loop for "nights" drop-down
		for(int i=0;i<ddl.size();i++)
		{
			String x=ddl.get(i).getAttribute("name");           
			if(x.equals("nights"))
			{
				Select s=new Select(ddl.get(i));
				s.selectByIndex(3); //4th item
			}
		}
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}





