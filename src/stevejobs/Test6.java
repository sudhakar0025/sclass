package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test6
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		//create object to ChromeDriver class to call methods
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(5000);
		String x=driver.getTitle();
		String y=driver.getPageSource();
		String z=driver.getCurrentUrl();
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		//close site
		driver.close();
	}
}




