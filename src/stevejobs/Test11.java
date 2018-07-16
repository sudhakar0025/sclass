package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test11
{
	public static void main(String[] args) throws Exception
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier"))
		                               .sendKeys("vinayisb4u");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
		                              .sendKeys("vinay@1993");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(50000);
		//Go to mailbox table
		WebElement t=driver.findElement(By.xpath(
		   "(//*[@role='tabpanel'])[1]/descendant::table/child::tbody"));
		List<WebElement> rl=t.findElements(By.tagName("tr"));
		System.out.println(rl.size());
		Thread.sleep(10000);
		//Do logout
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]/child::*"))
			.click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}






