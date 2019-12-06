import java.util.TreeSet;

public class TreeSet2 {
	public static void main(String[] args) {
		TreeSet<Student> t1=new TreeSet<Student>();
		
		t1.add(new Student(22,"Ankita"));
		t1.add(new Student(23,"Abc"));
		
		t1.add(new Student(43,"john"));
		
		for (Student s1 : t1) {
			System.out.println(s1);
			
		}
		}

}
