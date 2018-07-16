package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test104
{
	public static void main(String[] args)
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch237\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(       
				By.name("q")));
		//Get title of site
		String t=driver.getTitle();
		//Validation
		if(t.equals("Google"))
		{
			System.out.println("Title test passed");
		}
		else
		{
			System.out.println("Title test failed");
		}
		//Close site
		driver.close();	
	}
}





