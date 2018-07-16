package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Test2
{
	public static void main(String[] args) throws InterruptedException
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
		                                  .sendKeys("Abdul");
		driver.findElement(By.name("lastName"))
		                                   .sendKeys("kalam");
		driver.findElement(By.name("phone"))
		                              .sendKeys("9000456713");
		driver.findElement(By.name("userName"))
		                      .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("address1"))
		                           .sendKeys("Mosque street");
		driver.findElement(By.name("address2"))
		                        .sendKeys("Dhanushkoti road");
		driver.findElement(By.name("city"))
		                        .sendKeys("Rameshwaram");
		driver.findElement(By.name("state"))
		                        .sendKeys("TamilNadu");
		driver.findElement(By.name("postalCode"))
		                          .sendKeys("600381");
		Select s=new Select(driver.findElement(
				                  By.name("country")));
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email"))
		                         .sendKeys("abdulkalam11");
		driver.findElement(By.name("password"))
		                     .sendKeys("batch237sleeping");
		driver.findElement(By.name("confirmPassword"))
		                      .sendKeys("batch237sleeping");
		driver.findElement(By.name("register")).click();
		Thread.sleep(5000);
		driver.close();
	}
}
