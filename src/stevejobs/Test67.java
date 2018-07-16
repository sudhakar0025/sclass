package stevejobs;
import java.util.Scanner;
public class Test67
{
	public static void main(String[] args)
	{
		//Get a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		String x=sc.nextLine();
		//Converted to words
		for(int i=0;i<x.length();i++)
		{
			String y="";
			char c=x.charAt(i);
			switch(c)
			{
			case '0':
				y="zero";
				break;
			case '1':
				y="one";
				break;
			case '2':
				y="two";
				break;
			case '3':
				y="three";
				break;
				
			case '4':
				y="four";
				break;
				
			case '5':
				y="five";
				break;
			case '6':
				y="six";
				break;
			case '7':
				y="seven";
				break;
			case '8':
				y="eight";
				break;
			case '9':
				y="nine";
				break;	
			}
			System.out.print(y+" ");
		}

	}

}
