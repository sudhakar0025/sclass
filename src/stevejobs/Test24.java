package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test24
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
                	"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.mercurytravels.co.in");         
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Collect all drop-downs
		List<WebElement> ddl=
				driver.findElements(By.tagName("select"));
		int tcdd=ddl.size();
		int vcdd=0;
		int ivcdd=0;
		int ssdd=0;
		int msdd=0;
		for(int i=0;i<tcdd;i++)
		{
			//visible or not
			if(ddl.get(i).isDisplayed())
			{
				vcdd=vcdd+1;
			}
			else
			{
				ivcdd=ivcdd+1;
			}
			//Multi-select or not
			Select s=new Select(ddl.get(i));
			if(s.isMultiple())
			{
				msdd=msdd+1;
			}
			else
			{
				ssdd=ssdd+1;
			}	
		}
		System.out.println(
				"Tootal count of drop-downs is "+tcdd);
		System.out.println(
				"Visible count of drop-downs is "+vcdd);
		System.out.println(
				"Invisible count of drop-downs is "+ivcdd);
		System.out.println(
				"Count of single-select drop-downs is "+ssdd);
		System.out.println(
				"Count of multi-select drop-downs is "+msdd);
		//Close site 
		driver.close();
	}
}
