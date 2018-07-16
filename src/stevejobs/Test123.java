package stevejobs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Test123
{
	public static void main(String[] args) throws Exception
	{
		//Open 1st text file for reading
		File f1=new File("mydata.txt");
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		//Open 2nd text file for results writing
		File f2=new File("myresults.txt");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw);
		//Data driven
		String l="";
		int ucc=0,lcc=0,dc=0,scc=0;
		while((l=br.readLine())!=null)
		{
			for(int i=0;i<l.length();i++)
			{
				char c=l.charAt(i);
				if(c>=97 && c<=122)
				{
					lcc=lcc+1;
				}
				else if(c>=65 && c<=90)
				{
					ucc=ucc+1;
				}
				else if(c>=48 && c<=57)
				{
					dc=dc+1;
				}
				else
				{
					scc=scc+1;
				}
			}
		}
		//Make output
		bw.write("Count of Lower case chars is "+lcc);
		bw.newLine();
		bw.write("Count of Upper case chars is "+ucc);
		bw.newLine();
		bw.write("Count of digits is "+dc);
		bw.newLine();
		bw.write("Count of special chars is "+scc);         
		//Close files
		bw.close();
		fw.close();
		br.close();
		fr.close();
	}
}
