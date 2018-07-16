package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test36
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser
		System.setProperty("webdriver.chrome.driver",
            	"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");         
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Click an element
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//Locate element using SWD & operate using Javascript
		WebElement e=driver.findElement(By.name("identifier"));
		js.executeScript("arguments[0].style.border='2px dashed blue';",e);
		js.executeScript("arguments[0].value='kalam';",e);
		Thread.sleep(5000);
		//Locate and operate element using javascript
		js.executeScript("document.getElementById('identifierNext').click();");

	}

}






