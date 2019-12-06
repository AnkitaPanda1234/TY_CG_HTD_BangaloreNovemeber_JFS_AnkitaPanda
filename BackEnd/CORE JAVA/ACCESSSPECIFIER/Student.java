package com.tyss.access.pack1;

public class Student {
	protected String studName;
	
	protected Student(String name)
	{
		this.studName=name;
	}
      protected void studDetails()
      {
    	  System.out.println("Student name is"+studName);
      }
}
