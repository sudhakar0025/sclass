package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Test32
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
		//Automate <div> tag single select drop-down
		WebElement e1=driver.findElement(By.xpath(
				          "(//*[@class='ui dropdown'])[1]"));
		Actions a=new Actions(driver);
		a.click(e1).build().perform();
		Thread.sleep(5000);
		for(int i=1;i<=4;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
		}
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//Automate <div> tag single select drop-down
		WebElement e2=driver.findElement(By.xpath(
				"(//*[@class='ui selection dropdown'])[1]"));
		a.click(e2).build().perform();
		Thread.sleep(5000);
		a.sendKeys("f").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
	}
}






