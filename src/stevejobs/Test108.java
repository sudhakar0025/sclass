package stevejobs;

import java.util.Scanner;

public class Test108
{
	public static void main(String[] args)
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Grade");
		String x=sc.nextLine();
		char y=x.charAt(0);
		switch(y)
		{
			case 'A':
				System.out.println("Grade A");
				break;
			case 'B':
				System.out.println("Grade B");
				break;
			default:
				System.out.println("Not qualified");                  
				break;	
		}	
	}

}
