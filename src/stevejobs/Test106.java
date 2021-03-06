package stevejobs;
import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Test106
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String m=sc.nextLine();
		System.out.println(
		 "Enter mobile number criteria as valid or invalid");
		String mc=sc.nextLine();
		System.out.println("Enter Password");
		String p=sc.nextLine();
		System.out.println(
		     "Enter Password criteria as valid or invalid");
		String pc=sc.nextLine();
		//Create results file(.html)
		ExtentReports er=new ExtentReports(
				              "w2smstestresults.html",false);
		ExtentTest et=er.startTest("W2SMS Login Test");
		WebDriver driver=null;
		try
		{
			//Run browser driver to get browser                    
			System.setProperty("webdriver.chrome.driver",
					       "E:\\batch237\\chromedriver.exe");
			//Create object to access that opened browser
			driver=new ChromeDriver();
			//Launch site
			driver.get(
				  "http://site21.way2sms.com/content/index.html");
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(
					                       By.name("username")));
			driver.manage().window().maximize();
			//Do login
			driver.findElement(By.name("username")).sendKeys(m);
			driver.findElement(By.name("password")).sendKeys(p);
			driver.findElement(By.id("loginBTN")).click();
			Thread.sleep(5000);
			//Validations
			if(m.length()==0 && 
					ExpectedConditions.alertIsPresent()!=null)
			{
				et.log(LogStatus.PASS,
						"Test passed for blank mobile number");
			}
			else if(m.length()<10 && 
					 ExpectedConditions.alertIsPresent()!=null)
			{
				et.log(LogStatus.PASS,
						"Test passed for wrong size of mobile number");
			}
			else if(p.length()==0 && 
					ExpectedConditions.alertIsPresent()!=null)
			{
				et.log(LogStatus.PASS,"Test passed for blank password");
			}
			else if(mc.equalsIgnoreCase("invalid") &&
					driver.findElement(By.xpath(
					"//*[contains(text(),'registered yet')]"))
					.isDisplayed())
			{
				et.log(LogStatus.PASS,
					"Test passed for invalid mobile number");
			}
			else if(mc.equalsIgnoreCase("valid") && 
				pc.equalsIgnoreCase("invalid") && 
				driver.findElement(By.xpath(
				"//*[contains(text(),'Forgot Password')]"))
				.isDisplayed())
		   {
				et.log(LogStatus.PASS,
					     "Test passed for invalid Password");
		   }
		   else if(mc.equalsIgnoreCase("valid") && 
				pc.equalsIgnoreCase("valid") &&
				driver.findElement(By.xpath(
				"//*[text()='Send SMS']")).isDisplayed())
		   	{
			   et.log(LogStatus.PASS,"Test passed for valid data");
		   	}
		   	else
		   	{
		   		File src=((TakesScreenshot)driver).getScreenshotAs(
                                                   OutputType.FILE);
		   		File dest=new File("ss1.png");
		   		FileUtils.copyFile(src,dest);
		   		et.log(LogStatus.FAIL,
		   			  "Test failed"+et.addScreenCapture("ss1.png"));
		   	}
			//Close site
			driver.close();
		}
		catch(Exception e)
		{
			File src=((TakesScreenshot)driver).
					getScreenshotAs(OutputType.FILE);
			File dest=new File("ss2.png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.ERROR,
			   e.getMessage()+et.addScreenCapture("ss2.png"));
			driver.close();
		}
		//Save results
		er.endTest(et);
		er.flush();
	}
}
