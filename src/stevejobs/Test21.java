package stevejobs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test21 
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
		//Maximize
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get size
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();   
		System.out.println(w+" "+h);
		//Change size
		Dimension d=new Dimension(300,200); //width, height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get position
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		//Change position
		Point p=new Point(400,400); //x & y coordinates
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}






