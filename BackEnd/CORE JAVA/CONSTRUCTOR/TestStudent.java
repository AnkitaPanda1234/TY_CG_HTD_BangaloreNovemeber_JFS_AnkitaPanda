
public class TestStudent {

	public static void main(String[] args) {
		Student s1=new Student();
		
		System.out.println(s1.studName);
		System.out.println(s1.studAge);
		
		Student s2=new Student("Ankita",21);
		System.out.println(s2.studName);
		System.out.println(s2.studAge);
		
	}

}
