
public class Son extends Father {
	Son()
	{
		System.out.println("c");
	}
	
	Son(String name,int age)
	{
		this();
		System.out.println("D");
	}

}
