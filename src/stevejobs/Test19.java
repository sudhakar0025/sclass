package stevejobs;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test19 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
		             "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//goto gmail
		driver.navigate().to("http://www.gmail.com");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.close();
	}
}





