package com.tyss.access.pack1;

public class TestEmployee {

	public static void main(String[] args) {
		Employee e1=new Employee("Ankita");
		System.out.println("name is"+e1.name);
		e1.details();//default access specifier are executed because of same package
	}

}
