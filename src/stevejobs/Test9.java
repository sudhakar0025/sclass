package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 
{
	public static void main(String[] args) throws Exception
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(5000);
		//click register
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		//Fill fields
		driver.findElement(By.name("firstName"))
		              .sendKeys("Abdul",Keys.TAB,"kalam",Keys.TAB,"9000456713",Keys.TAB,"apj@abdulkalam.com",Keys.TAB,"Mosque street");
		Thread.sleep(5000);
		driver.findElement(By.name("firstName")).sendKeys(Keys.chord(Keys.CONTROL,"a"),
				                                          Keys.chord(Keys.CONTROL,"c"));
	}

}






