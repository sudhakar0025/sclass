package stevejobs;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test113
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");                        
		String x=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.gecko.driver",
				       "E:\\batch237\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.co.in");
		//To give time to browser to show page
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                               By.name("q")));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,
				                           TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		//Results pages are ready to navigate(pagination)
		int flag=0;
		while(2>1) //infinite loop
		{
			String t=driver.getTitle();
			if(!t.contains(x))
			{
				flag=1;
				break;  //terminate from infinite loop
			}
			//goto next page of results
			try
			{
				if(driver.findElement(By.xpath("//*[text()='Next']"))
						                                .isDisplayed())
				{
					driver.findElement(By.xpath("//*[text()='Next']"))
					                                          .click();
					Thread.sleep(2000);
				}
			}
			catch(Exception e)
			{
				break; //To terminate from infinite loop
			}	
		}
		//validation
		if(flag==0)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//close site
		driver.close();
	}
}







