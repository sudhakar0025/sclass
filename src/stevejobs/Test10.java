package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test10
{
	public static void main(String[] args) throws Exception
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		List<WebElement> l=driver.findElements(By.xpath("//*"));
		System.out.println(l.size());
		driver.close();

	}

}











