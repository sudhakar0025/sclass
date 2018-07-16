package stevejobs;
import java.util.Scanner;
public class Test118
{
	public static void main(String[] args)
	{
		//Declare 5 numbers static array
		int x[]=new int[5];
		//Store 5 numbers into array
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter a number");
			x[i]=sc.nextInt();
		}
		//Sorting
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j]>x[j+1])
				{
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		//Display array numbers after sorting                         
		for(int i=0;i<5;i++)
		{
			System.out.print(x[i]+" ");
		}
	}
}



