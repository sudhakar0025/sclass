package stevejobs;

import java.util.Scanner;

public class Test110
{
	public static void main(String[] args)
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter credit card type");
		String x=sc.nextLine();
		switch(x)
		{
			case "visa":
				System.out.println("Valid");
				break;
			case "master":
				System.out.println("Valid");
				break;
			default:
				System.out.println("Wrong type");                    
				break;
		}
		

	}

}
