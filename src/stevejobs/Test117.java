package stevejobs;

import java.util.Scanner;

public class Test117
{
	public static void main(String[] args) 
	{
		//Get limit from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit");
		int l=sc.nextInt();
		int x=0;
		System.out.print(x+" ");
		int y=1;
		System.out.print(y+" ");
		int z=x+y;
		do
		{
			if(z>l)
			{
				break;
			}
			System.out.print(z+" ");
			x=y;
			y=z;
			z=x+y;
		}while(2>1);
	}
}
