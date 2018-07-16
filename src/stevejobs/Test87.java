package stevejobs;

public class Test87
{
	public static void main(String[] args) 
	{
		Example3 obj1=new Example3();
		//JVM can run default & matched constructor for "obj1"
		System.out.println(obj1.x);
		System.out.println(obj1.y);
		System.out.println(obj1.z);
		System.out.println(obj1.w);
		System.out.println(obj1.s);	
		Example3 obj2=new Example3((float)67.8,"steve jobs");
		//JVM can run default & matched constructor for "obj2"
		System.out.println(obj2.x);
		System.out.println(obj2.y);
		System.out.println(obj2.z);
		System.out.println(obj2.w);
		System.out.println(obj2.s);
	}
}
