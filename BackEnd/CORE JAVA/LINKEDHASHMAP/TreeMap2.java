 package comm.tyss.treeMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap2 {
	public static void main(String[] args) {
		TreeMap<Student,String> t1=new TreeMap<Student,String>();
		t1.put(new Student(12,"Ankita"),"First Standerd");
		t1.put(new Student(14,"sima"),"second Standerd");
		t1.put(new Student(23,"Rany"),"third Standerd");
		
		SortingAge s2=new SortingAge();
		
		System.out.println(t1.get(new Student(12,"Ankita")));
		
		 
		Set<Map.Entry<Student, String>> s1= t1.entrySet();
		
		for (Map.Entry<Student, String> e1 : s1) {
			System.out.println(e1.getValue());
			System.out.println(e1.getKey());
		
		
	}

	}
}
