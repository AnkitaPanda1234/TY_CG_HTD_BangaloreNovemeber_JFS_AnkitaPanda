package com.tyss.HashMap.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap1 {
	public static void main(String[] args) {
		LinkedHashMap <String,Integer>l1=new LinkedHashMap <String,Integer> ();
		
		l1.put("BTM",1234);
		l1.put("OAR", 560091);
		l1.put("BTR", 567800);
		l1.put("Rajajinagar",670098);
		l1.put(null,780087);
		
		l1.remove("BTR");
		
		Set<Map.Entry<String,Integer>> s1=l1.entrySet();
		
		for (Map.Entry<String, Integer> e1 : s1) {
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());	
		     }
		System.out.println("......");
		
		System.out.println(l1.size());
		System.out.println(l1.isEmpty());
		System.out.println(l1.containsKey("BTM"));
		System.out.println(l1.containsValue(1234));
		
		
	}

}
