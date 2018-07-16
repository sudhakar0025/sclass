package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8
{
	public static void main(String[] args) throws Exception
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		//create object to ChromeDriver class to call methods
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site using base url
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Enter email id
		driver.findElement(By.name("identifier")).sendKeys("mindq1234",Keys.ENTER);
		Thread.sleep(5000);
		
		

	}

}





