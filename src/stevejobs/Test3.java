package stevejobs;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
public class Test3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Get browser name
		System.out.println("Enter browser name");
		Scanner sc=new Scanner(System.in);  //java.util
		String x=sc.nextLine();
		//create driver object w.r.t browser
		WebDriver driver=null;
		if(x.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"E:\\batch237\\chromedriver.exe");          
			driver=new ChromeDriver();
		}
		else if(x.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"E:\\batch237\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(x.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"E:\\batch237\\iedriverserver.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Unknown browser");
			System.exit(0); //stop execution forcibly
		}
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








