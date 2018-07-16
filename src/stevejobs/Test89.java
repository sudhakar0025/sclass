package stevejobs;
public class Test89
{
	public static void main(String[] args) 
	{
		Example5 obj=new Example5();
		int r1=obj.add();
		System.out.println(r1); //30
		int r2=obj.add(40);
		System.out.println(r2); //60
		int r3=obj.add(40,60);
		System.out.println(r3); //100
	}
}


