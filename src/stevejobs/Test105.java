package stevejobs;
import java.io.File;
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
public class Test105
{
	public static void main(String[] args) throws Exception
	{
		//Create a html file for results with appending
		ExtentReports er=
			new ExtentReports("googlesitetestresults.html",false); 
		ExtentTest et=er.startTest("Google title test");
		try
		{
			//Launch site
			System.setProperty("webdriver.chrome.driver",
				"E:\\batch237\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.google.co.in");
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(       
												By.name("q")));
			driver.manage().window().maximize();
			//Get title of site
			String t=driver.getTitle();
			//Validation
			if(t.equals("Google"))
			{
				et.log(LogStatus.PASS,"Title test passed");
			}
			else
			{
				File src=((TakesScreenshot)driver).getScreenshotAs(
                        OutputType.FILE);
				File dest=new File("ss.png");
				FileUtils.copyFile(src,dest);
				et.log(LogStatus.FAIL,"Title test failed "+et.addScreenCapture("ss.png"));	
			}
			//close site
			driver.close();
		}
		catch(Exception e)
		{
			et.log(LogStatus.ERROR,e.getMessage());
		}
		//Save and close results
		er.endTest(et);
		er.flush();
	}
}






