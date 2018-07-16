package stevejobs;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
public class Test55
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser(Java)                    
		System.setProperty("webdriver.chrome.driver",
				  "E:\\batch237\\chromedriver.exe");
		//Create object to access that opened browser(SWD)
		WebDriver driver=new ChromeDriver();
		//Launch site(SWD)
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		//Capture screenshot of full screen
		Screen s=new Screen();
		ScreenImage si=s.capture();
		BufferedImage bi=si.getImage();
		File f1=new File("E:\\batch237\\fullscreen.png");
		ImageIO.write(bi,"png",f1);
		//Capture region of screen
		Region r=new Region(200,300,200,100); //x,y,width,height
		ScreenImage sr=s.capture(r);
		BufferedImage br=sr.getImage();
		File f2=new File("E:\\batch237\\region.png");
		ImageIO.write(br,"png",f2);
		//Close site(SWD)
		driver.close();
	}
}
