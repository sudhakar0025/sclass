package stevejobs;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test7
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		//create object to ChromeDriver class to call methods
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site using base url
		driver.get(
				"http://site24.way2sms.com/content/index.html");
		Thread.sleep(5000);
		String x=driver.getCurrentUrl();
		if(x.contains("https"))
		{
			System.out.println("Secured site");
		}
		else
		{
			System.out.println("Not secured");
		}
		//close site
		driver.close();
	}
}
