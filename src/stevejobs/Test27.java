package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test27 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
            	"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");         
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		//Automate multi-select drop-down
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		a.click(s.getOptions().get(1)).build().perform();
		Thread.sleep(5000);
		a.click(s.getOptions().get(3)).build().perform();
		Thread.sleep(5000);
		a.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		s.deselectByVisibleText("Audi");
		Thread.sleep(5000);
		driver.close();
		

	}

}
