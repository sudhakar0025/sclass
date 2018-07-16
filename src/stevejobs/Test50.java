package stevejobs;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test50 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier"))
									.sendKeys("sk1994501");
		driver.findElement(By.id("identifierNext")).click();   
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
		                      .sendKeys("7799645934");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(5000);
		//Click compose
		driver.findElement(By.xpath("//*[text()='COMPOSE']"))
		                                            .click();
		Thread.sleep(5000);
		//fill fields
		driver.findElement(By.name("to"))
		                 .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("subjectbox"))
		                 .sendKeys("Hi");
		driver.findElement(By.xpath(
				"(//*[@aria-label='Message Body'])[2]"))
				.sendKeys("Hi sir\nHow are you in haven");
		driver.findElement(By.xpath(
			"//*[@aria-label='Attach files']/descendant::*[3]"))
				.click();
		Thread.sleep(5000);
		//Handle File upload window
		Robot r=new Robot();
		StringSelection fp=new StringSelection(
		"C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard()
		                                  .setContents(fp,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@role='progressbar']")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(
							By.xpath("//*[@role='progressbar']")));
		//Send mail
		driver.findElement(By.xpath("//*[text()='Send']"))
							.click();
		Thread.sleep(5000);
		String msg=driver.findElement(By.xpath(
		  "(//*[@aria-live='assertive'])[3]/descendant::*[3]"))
		  							.getText();
		System.out.println(msg);
		//Do logout
		driver.findElement(By.xpath(
		"//*[@aria-label='Account Information']/preceding::*[3]"))
											.click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
