package stevejobs;

import java.util.Scanner;

public class Test112
{
	public static void main(String[] args)
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");                        
		String x=sc.nextLine();
		System.out.println("Enter a charecter");
		String y=sc.nextLine();
		char z=y.charAt(0);
		//Remove given char from string
		String w="";
		for(int i=0;i<x.length();i++)
		{
			char temp=x.charAt(i);
			if(temp==z)
			{
				w=w+"";
			}
			else
			{
				w=w+temp;
			}
		}
		x=w;
		System.out.println(x);
	}

}







