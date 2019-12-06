package comm.tyss.treeMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap3 {
	public static void main(String[] args) {
		ArrayList<Student2> l1= new ArrayList<Student2>();
		
		l1.add(new Student2(12,"Ankita"));
		l1.add(new Student2(23,"soma"));
		l1.add(new Student2(12,"ranu"));
		TreeMap<String,ArrayList<Student2>> t1=new TreeMap<String,ArrayList<Student2>>();
		t1.put("1st Standard",l1);
		t1.put("2nd standred",l1);
		t1.put("3rd standrad",l1);
		
		Set<Map.Entry<String,ArrayList<Student2>>> s2= t1.entrySet();
		
		for (Map.Entry<String, ArrayList<Student2>> entry : s2) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}

}
