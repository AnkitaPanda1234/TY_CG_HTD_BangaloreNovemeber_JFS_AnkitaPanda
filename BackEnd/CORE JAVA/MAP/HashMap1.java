package com.tyss.map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMap1 
     {
        public static void main(String[] args) {
			HashMap<Integer,String> h1=new HashMap<Integer,String>();
			h1.put(2, "Ankita");
			h1.put(8, "Ranu");
			h1.put(6, "Seema");
			h1.put(4, "Richa");
			
			Set<Map.Entry<Integer, String>> s1=h1.entrySet();
			for(Map.Entry<Integer, String> e1:s1)
			{
				System.out.println(e1.getKey());
				System.out.println(e1.getValue());
				System.out.println(".................");
			}
			
		}
}
