package stevejobs;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test16
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
		Thread.sleep(5000);
		//Click on google play
		driver.findElement(By.xpath(
				"//*[contains(@src,'android-button.png')]"))
				.click();
		Thread.sleep(5000);
		//Get window handles into an array
		ArrayList<String> wins=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(1));
		driver.close();
		driver.switchTo().window(wins.get(0));
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("username")).sendKeys("9439922064");
		driver.findElement(By.name("password")).sendKeys("2868");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Send SMS']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("frame");
		driver.findElement(By.name("mobile")).sendKeys("9160677368");
		driver.findElement(By.name("message")).sendKeys("Amma nanna one testing job");
		driver.findElement(By.name("Send")).click();
	}
}





