package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test41
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser                    
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch237\\chromedriver.exe");
		//Create object to access that opened browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Click a link and wait for completion of operation
		driver.findElement(By.linkText("25")).click();
		WebDriverWait w=new WebDriverWait(driver,100); //time in seconds
		w.until(ExpectedConditions.
		 invisibilityOfElementLocated(By.className("raDiv")));
		//Close site
		driver.close();

	}

}
