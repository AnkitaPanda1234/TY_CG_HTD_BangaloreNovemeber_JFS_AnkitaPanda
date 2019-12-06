package com.tyss.map.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMap2 {
	public static void main(String[] args) {
		HashMap<Integer,Student> h1=new HashMap<Integer,Student>();
		
		h1.put(21,new Student(22,"Ankita"));
		h1.put(24,new Student(25,"Ranu"));
		h1.put(null, null);
		h1.put(null,new Student(34,"Soma"));
		h1.put(21,new Student(89,"Ankita"));
		
		        Collection<Student> c1= h1.values();
		      for (Student s1 : c1) {
		    	  System.out.println(s1);
			
		             }
		      System.out.println("............");
		        Set<Integer> s1=h1.keySet();
		        for(Integer a1:s1)
		        {
		        	System.out.println(a1);
		        }
		        
		       
		  System.out.println(h1.containsKey(21));
		  System.out.println(h1.containsValue(new Student(25,"Ranu")));
		  System.out.println(h1.size());
		  System.out.println(h1.isEmpty());
	}

}
