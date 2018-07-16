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

public class Test115
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
		ExtentTest et=er.startTest("Gmail Mail deletion Test");
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
			//Maximize browser
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
			//Get all mails count before deletion
			String x=driver.findElement(By.xpath(
		            "(//*[@class='ts'])[3]")).getText();
			int amcbd=Integer.parseInt(x);
			//Pagination to delete mails
			int dmc=0;
			while(2>1)
			{
				int mc=driver.findElements(By.xpath(
					"(//*[@role='tabpanel'])[1]/descendant::tbody/tr"))
					.size();
				for(int i=1;i<=mc;i++)
				{
					String t=driver.findElement(By.xpath(
					 "(//*[@role='tabpanel'])[1]/descendant::tbody/tr["
					  +i+"]/td[8]/span")).getAttribute("title");
					if(t.contains("May") && t.contains("2018"))
					{
						driver.findElement(By.xpath(
					     "(//*[@role='tabpanel'])[1]/descendant::tbody/tr["
						 +i+"]/td[2]/div")).click();
						Thread.sleep(5000);						
						driver.findElement(By.xpath(
						  "(//*[@class='G-Ni J-J5-Ji'])[2]/div[3]")).click();
						Thread.sleep(5000);
						dmc=dmc+1;
						i=i-1;//to check next mail which is in deleted mail place 
					}
					mc=driver.findElements(By.xpath(
						"(//*[@role='tabpanel'])[1]/descendant::tbody/tr"))
						.size();
				}
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
			//Get all mails count after deletion
			String temp=driver.findElement(By.xpath(
					            "(//*[@class='ts'])[3]")).getText();
			int amcad=Integer.parseInt(temp);
			//Validation
			if(amcbd==amcad+dmc)
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
