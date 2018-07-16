package stevejobs;
import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
public class Test75
{
	public static void main(String[] args) throws Exception
	{
		//Take any image file, which have text in content
		File f=new File("E:\\untitled.png"); 
		//Load "tessdata" file
		File fo=LoadLibs.extractTessResources("tessdata");           
		Tesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());
		//Convert image content as text
		String result=obj.doOCR(f);
		Thread.sleep(20000);
		System.out.println(result);
	}
}


