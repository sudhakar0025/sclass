package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test46
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver", 
				"E:\\batch237\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys("hdtjhdc");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input#identifierNext[role=button]")).click();
	}

}





