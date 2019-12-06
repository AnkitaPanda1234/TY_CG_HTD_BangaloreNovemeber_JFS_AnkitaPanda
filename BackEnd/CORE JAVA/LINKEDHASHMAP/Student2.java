package comm.tyss.treeMap;

public class Student2 implements Comparable<Student2> {
	
	@Override
	public String toString() {
		return "Student2 [age=" + age + ", name=" + name + "]";
	}
	int age;
	String name;
	public Student2(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Student2 o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
