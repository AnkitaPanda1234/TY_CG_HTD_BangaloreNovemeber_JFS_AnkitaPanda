package exceptionPropagation;

public class A {
	public static void main(String[] args) {
		System.out.println("main started");
		try{
		B.m();
	      }
		catch(ClassNotFoundException e)
		{
			System.out.println("class not found handled in A class");
		}
		System.out.println("main ended");
		
		
		
	}

}
