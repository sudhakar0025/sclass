package stevejobs;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test22 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
	                    "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Delete all existing cookies
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Get cookies for validation
		if(driver.manage().getCookies().size()!=0)              
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





