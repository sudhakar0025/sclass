package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test40
{
	public static void main(String[] args)
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
	     	       "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");         
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                               By.name("q")));  
		driver.manage().window().maximize();
		driver.close();
		
		
		
	}
}
