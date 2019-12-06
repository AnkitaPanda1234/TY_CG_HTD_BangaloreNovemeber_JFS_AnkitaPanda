package staticAndNonstatic;

public class Person {
	static int age;
	String name;
	void personDetails()
	{
		System.out.println("person name is"+ " "+name+" "+"and age is"+age);
		Person.personDetailsStatic();
	}
	
	static void personDetailsStatic()
	{
		System.out.println(age);
	}

}
