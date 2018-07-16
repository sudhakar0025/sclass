package stevejobs;

import java.util.ArrayList;
import java.util.Scanner;

public class Test119
{
	public static void main(String[] args)
	{
		//Declare dynamic array
		ArrayList<Integer> x=new ArrayList<Integer>();
		//Get limit from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Array size");
		int n=sc.nextInt();
		//Fill array with numbers
		System.out.println("Enter "+n+" numbers");                   
		for(int i=0;i<n;i++)
		{
			x.add(sc.nextInt());
		}
		//Sorting
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x.get(j)>x.get(j+1))
				{
					int temp=x.get(j);
					x.set(j,x.get(j+1));
					x.set(j+1,temp);	
				}
			}
		}
		//Display array after sorting
		for(int i=0;i<n;i++)
		{
			System.out.print(x.get(i)+" ");
		}
	}

}
