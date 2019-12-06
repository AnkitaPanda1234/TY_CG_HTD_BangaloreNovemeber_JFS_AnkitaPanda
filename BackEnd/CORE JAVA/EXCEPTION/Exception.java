
public class Exception {
	void exception(int a,String b)
	{
		try{
			System.out.println(500/a);
			System.out.println(b.length());
		}
		catch(ArithmeticException e)
		{
			System.out.println("don't deal with 0");
		}
		catch(NullPointerException n)
		{
			System.out.println("dont deal with null");
		}
	}

}
