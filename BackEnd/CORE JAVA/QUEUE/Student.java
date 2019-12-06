package com.tyss.queue.priorityQueue;

public class Student implements Comparable<Student> {
	int age;
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	String name;
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
	public int compareTo(Student o) {
		if(this.age>o.age)
		{
			return 1;
		}
		else if(this.age<o.age)
		{
			return -1;
		}
		else
		{
			return 0;
		}
		
	}
	
        
}
