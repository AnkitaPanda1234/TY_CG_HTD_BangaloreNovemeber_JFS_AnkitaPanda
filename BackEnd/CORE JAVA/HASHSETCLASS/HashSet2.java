import java.util.HashSet;

public class HashSet2 {
	public static void main(String[] args) {
		HashSet<Student> h1=new HashSet<Student>();
		
		h1.add(new Student(22,"Ankita"));
		h1.add(new Student(23,"Abc"));
		h1.add(new Student(22,"Ankita"));
		h1.add(new Student(24,"abcd"));
		for (Student s1 : h1) {
			System.out.println(s1.studId + "and age is" +s1.studName);
			
		}
		
		
	}

}
