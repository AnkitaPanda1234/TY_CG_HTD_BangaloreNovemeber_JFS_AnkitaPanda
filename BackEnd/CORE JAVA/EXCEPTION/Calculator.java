
public class Calculator {
	void divide(int a,int b)
	{
		System.out.println("divide method called");
		try{	
		System.out.println(a/b);
		}
		catch(ArithmeticException e)
		{
			System.out.println("don't divide by zero");
		}
		System.out.println("divided");
	}

}
