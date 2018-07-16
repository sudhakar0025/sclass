package stevejobs;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test114
{
	public static void main(String[] args)
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter valid Userid");
		String u=sc.nextLine();
		System.out.println("Enter valid Password");
		String p=sc.nextLine();
		//Create results file(.html)
		ExtentReports er=new ExtentReports(
				              "gmailtestresults.html",false);
		ExtentTest et=er.startTest("Gmail Mailbox count Test");
		WebDriver driver=null;
		try
		{
			//Launch site                
			System.setProperty("webdriver.gecko.driver",
					       "E:\\batch239\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("http://www.gmail.com");
			//To give time to browser to show page
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(
					                      By.name("identifier")));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,
					                           TimeUnit.SECONDS);
			//Enter userid and password to do login
			driver.findElement(By.name("identifier")).sendKeys(u);
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(
					                             By.name("password")));
			driver.findElement(By.name("password")).sendKeys(p);
			w.until(ExpectedConditions.elementToBeClickable(
					                  By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(
					               By.xpath("//*[text()='COMPOSE']")));
			//Pagination to count all mails
			int eamc=0;
			while(2>1)
			{
				int mc=driver.findElements(By.xpath(
					"(//*[@role='tabpanel'])[1]/descendant::tbody/tr"))
					.size();
				eamc=eamc+mc;
				//Go to next page
				try
				{
					if(driver.findElement(By.xpath(
							"//*[@data-tooltip='Older']"))
							.getAttribute("aria-disabled")
							.equals("true"))
					{
						break; //To terminate from loop
					}
				}
				catch(Exception e)
				{
					driver.findElement(By.xpath(
							    "//*[@data-tooltip='Older']")).click();
					Thread.sleep(5000);
				}
			}
			System.out.println(eamc);
			//Get actual mails count
			String temp=driver.findElement(By.xpath(
					            "(//*[@class='ts'])[3]")).getText();
			int aamc=Integer.parseInt(temp);
			System.out.println(aamc);
			//Validation
			if(eamc==aamc)
			{
				et.log(LogStatus.PASS,"Mails count test passed");
			}
			else
			{
				File src=((TakesScreenshot)driver).
						getScreenshotAs(OutputType.FILE);
				File dest=new File("ss1.png");
				FileUtils.copyFile(src,dest);
				et.log(LogStatus.FAIL,
				   "Mails count test failed"+et.addScreenCapture(
						                             "ss1.png"));
			}
			//Do logout
			driver.findElement(By.xpath(
				"//*[contains(@title,'Google Account')]")).click();
			driver.findElement(By.linkText("Sign out")).click();
			//Close site
			driver.close();
		}
		catch(Exception ex)
		{
			et.log(LogStatus.ERROR,ex.getMessage());
		}
		//Save results
		er.endTest(et);
		er.flush();
	}
}
