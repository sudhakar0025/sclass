package stevejobs;
public class Test90
{
	public static void main(String[] args)
	{
		Example6 obj1=new Example6();
		Example6 obj2=new Example6();
		obj1.x=10;
		obj1.y=20;
		obj1.display(); //10 20
		obj2.y=30;
		obj2.display(); //10 30
	}
}
