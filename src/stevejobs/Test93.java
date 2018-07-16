package stevejobs;
public class Test93
{
	public static void main(String[] args)
	{
		//create object to abstract class
		Example10 obj1=new Example11();
		int r1=obj1.multiply(45,56);
		System.out.println(r1); //2520
		//create object to concrete class
		Example11 obj2=new Example11();
		int r2=obj2.add(45,56);
		System.out.println(r2); //101
	}
}

