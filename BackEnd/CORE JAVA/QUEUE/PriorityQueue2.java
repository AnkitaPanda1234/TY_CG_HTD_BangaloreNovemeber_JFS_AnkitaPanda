package com.tyss.queue.priorityQueue;

import java.util.PriorityQueue;

public class PriorityQueue2 {
	public static void main(String[] args) {
		PriorityQueue<Student> p1=new PriorityQueue<Student>();
		    p1.offer(new Student(22,"Ankita"));
		    p1.offer(new Student(21,"soma"));
		    p1.offer(new Student(30,"rich"));
		    
		    for (Student s1 : p1) {
		    	System.out.println(s1);
				
			}
	}

}
