package stevejobs;

import java.util.Scanner;

public class Test116
{
	public static void main(String[] args)
	{
		//Get number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		int y=0;
		do
		{
			int d=x%10;
			y=y*10+d;
			x=(int)x/10;	
		}while(x!=0);
		System.out.println(y);                                         
	}

}






