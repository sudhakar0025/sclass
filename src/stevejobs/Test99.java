package stevejobs;
public class Test99
{
	public static void main(String[] args)
	{
		Example16 obj1=new Example16();
		obj1.print(); //print() in Example16
		Example17 obj2=new Example17();
		obj2.print(); //print() in Example17
		((Example16)obj2).print(); //print() in Example17
		Example16 obj3=new Example17();
		obj3.print(); //print() in Example17
	}
}





