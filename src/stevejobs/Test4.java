package stevejobs;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test4 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get(
				"http://site21.way2sms.com/content/index.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("username"))
									.sendKeys("9439922064");
		driver.findElement(By.name("password"))
									.sendKeys("2868");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		//Click on SendSMS
		driver.findElement(By.xpath("//*[text()='Send SMS']"))
													.click();
		Thread.sleep(5000);
		//Fill fields
		driver.switchTo().frame("frame"); //to frame
		driver.findElement(By.name("mobile"))
								.sendKeys("9160677368");
		driver.findElement(By.name("message"))
		                                .sendKeys("Hi");
		driver.findElement(By.name("Send")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent(); //to page
		if(driver.findElement(By.xpath(
		  "//*[text()='Install Chrome Plugin']")).isDisplayed())
		{
			driver.findElement(By.xpath(
				"//*[text()='Install Chrome Plugin']")).click();
			Thread.sleep(5000);
			Robot r=new Robot();
			for(int i=1;i<=2;i++)
			{
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(5000);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);	
		}
		//Get message
		driver.switchTo().frame("frame");
		String x=driver.findElement(By.xpath(
			"//*[@class='mess']/descendant::*[5]")).getText();
		System.out.println(x);
		driver.switchTo().defaultContent();
		//do logout
		driver.findElement(By.xpath("//*[@class='out louti']"))
		                                              .click();
		Thread.sleep(5000);	
		driver.close();
	}
}






