package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test1
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
				             "E:\\batch237\\chromedriver.exe");
		//Open site in chrome browser
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Enter input
		driver.findElement(By.name("q"))
		                        .sendKeys("kalam",Keys.ENTER);
		Thread.sleep(5000);
		//close site
		driver.close();
	}

}




