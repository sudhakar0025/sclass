package stevejobs;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test20
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
	             "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Take screen shot of active page
		File src=driver.getScreenshotAs(OutputType.FILE);       
		File dest=new File("mindq.png");
		FileUtils.copyFile(src,dest);
	}
}






