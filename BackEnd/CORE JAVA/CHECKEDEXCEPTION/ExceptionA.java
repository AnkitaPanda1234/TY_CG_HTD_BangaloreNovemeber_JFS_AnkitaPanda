package checkedexception;

public class ExceptionA {
	public static void main(String[] args) {
		System.out.println("main started");
		try {
			Class c1=Class.forName("checkedexception.Person");
			// if we r not write the package name thn it find the default package
			System.out.println("class is found");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("class is not found");			
		}
		System.out.println("main ended");
		
	}

}