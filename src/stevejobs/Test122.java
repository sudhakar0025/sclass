package stevejobs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class Test122
{
	public static void main(String[] args) throws Exception
	{
		//Open text file for data reading
		File f=new File("gmailtestdata.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		//Create results file(.html)
		ExtentReports er=new ExtentReports(
	              "gmail-login-ddt.html",false);          
		ExtentTest et=er.startTest("Gmail Login Test");
		//Data Driven Test
		WebDriver driver=null;
		String l="";
		while((l=br.readLine())!=null)
		{
			try
			{
				//Split line into pieces
				String p[]=l.split(",");
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
				//Enter userid and perform validations
				driver.manage().timeouts().implicitlyWait(20,
		                           TimeUnit.SECONDS);
				driver.findElement(By.name("identifier"))
	                                   .sendKeys(p[0]);
				w.until(ExpectedConditions.elementToBeClickable(
			                 By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				//To give time to browser to activate password or next 
				Thread.sleep(5000);
				if(p[1].equalsIgnoreCase("valid") &&
					driver.findElement(By.name("password"))
					.isDisplayed())
				{
					et.log(LogStatus.PASS,"Valid Userid test passed");
					//Enter password and perform validations
					driver.findElement(By.name("password"))
		                                               .sendKeys(p[2]);
					w.until(ExpectedConditions.elementToBeClickable(
				                      By.xpath("//*[text()='Next']")));
					driver.findElement(By.xpath("//*[text()='Next']"))
		                                                      .click();
					Thread.sleep(5000);
					if(p[3].equalsIgnoreCase("valid") &&
					   driver.findElement(By.xpath("//*[text()='COMPOSE']"))
					   .isDisplayed())
		            {				
						et.log(LogStatus.PASS,"Valid pwd test passed");
		            }
					else if(p[3].equalsIgnoreCase("invalid") && 
							driver.findElement(By.xpath(
							"//*[text()='Enter a password' or contains(text(),'Wrong password')]"))
							.isDisplayed())
					{
						et.log(LogStatus.PASS,"Invalid pwd test passed");	
					}
					else
					{
						File src=((TakesScreenshot)driver).getScreenshotAs(
                                            OutputType.FILE);
						File dest=new File("ss1.png");
						FileUtils.copyFile(src,dest);
						et.log(LogStatus.FAIL,
								"Pwd Test failed"+et.addScreenCapture("ss1.png"));
					}
				}
				else if(p[1].equalsIgnoreCase("invalid") &&
						driver.findElement(By.xpath(
						"(//*[contains(text(),'find your Google') or contains(text(),'Enter an email')])[2]"))
						.isDisplayed())
				{
					et.log(LogStatus.PASS,"Invalid userid test passed");
				}
				else
				{
					File src=((TakesScreenshot)driver).getScreenshotAs(
										   OutputType.FILE);
					File dest=new File("ss2.png");
					FileUtils.copyFile(src,dest);
					et.log(LogStatus.FAIL,
							"Userid Test failed"+et.addScreenCapture("ss2.png"));
				}
				//Close site
				driver.close();
			}
			catch(Exception e)
			{
				File src=((TakesScreenshot)driver).
						getScreenshotAs(OutputType.FILE);
				File dest=new File("ss3.png");
				FileUtils.copyFile(src,dest);
				et.log(LogStatus.ERROR,
						e.getMessage()+et.addScreenCapture("ss3.png"));
				driver.close();
			}
		}
		//Close text file
		br.close();
		fr.close();
		//Save results
		er.endTest(et);
		er.flush();	
	} 
}
