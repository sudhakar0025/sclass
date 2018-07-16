package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test35 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
            	"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://jqueryui.com/slider");         
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Automate horizontal slider
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.xpath(
				           "//*[@id='slider']/child::span"));
		int x1=e1.getLocation().getX();
		int y1=e1.getLocation().getY();
		Actions a=new Actions(driver);
		a.dragAndDropBy(e1,x1+300,y1).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1,x1-100,y1).build().perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent(); //back to page
		//Automate vertical slider
		driver.findElement(By.linkText("Vertical slider"))
		                                              .click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement e2=driver.findElement(By.xpath(
				    "//*[@id='slider-vertical']/child::span"));
		int x2=e2.getLocation().getX();
		int y2=e2.getLocation().getY();
		a.dragAndDropBy(e2,x2,y2+100).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e2,x2,y2-50).build().perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
}




