package stevejobs;
import java.util.Iterator;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
public class Test54
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(5000);
		Iterator<Match> l=s.findAll("file.png");                     
		int c=0;
		while(l.hasNext())
		{
			c=c+1;
			l.next();	
		}
		System.out.println(c);
		//Click on 2nd match
		l=s.findAll("file.png");
		l.next();
		l.next().click();
	}
}


