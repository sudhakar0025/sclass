package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
public class Test52
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser(SWD)
		System.setProperty("webdriver.chrome.driver",
	     	       "E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site(SWD)
		driver.get("http://www.youtube.com"); 
		Thread.sleep(5000);
		driver.manage().window().maximize();
		//Search for video(SWD)
		driver.findElement(By.name("search_query"))
		                          .sendKeys("Abdul kalam speeches");
		driver.findElement(By.xpath(
			 "(//*[@aria-label='Search'])[3]/child::*[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText(
				                "Abdul Kalam in European")).click();
		Thread.sleep(5000);
		//Automate video icons(SikuliX)
		Screen s=new Screen();
		if(s.exists("skipadd.png")!=null)
		{
			s.click("skipadd.png");
		}
		Location l=new Location(300,300);
		s.wheel(l,Button.LEFT,0);
		s.click("pause.png");
		Thread.sleep(5000);
		s.wheel(l,Button.LEFT,0);
		s.click("play.png");
		Thread.sleep(5000);
		s.wheel(l,Button.LEFT,0);
		s.mouseMove("volume.png");
		Match e=s.find("bubble.png");
		int x=e.getX();
		int y=e.getY();
		Location m=new Location(x-20,y);
		s.dragDrop(e,m);
		Thread.sleep(5000);
		s.wheel(l,Button.LEFT,0);
		s.mouseMove("volume.png");
		Location n=new Location(x+20,y);
		s.dragDrop(e,n);
		Thread.sleep(5000);
		s.wheel(Button.WHEEL_DOWN, 5);
		Thread.sleep(5000);
		//close site(SWD)
		driver.close();	
	}
}






