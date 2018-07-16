package stevejobs;
public class Test92
{
	public static void main(String[] args)
	{
		//create object to interface
		Example8 obj1=new Example9();
		int r1=obj1.add(45,56);
		System.out.println(r1);
		//create object to concrete class
		Example9 obj2=new Example9();
		int r2=obj2.add(45,56);
		System.out.println(r2);
	}
}

