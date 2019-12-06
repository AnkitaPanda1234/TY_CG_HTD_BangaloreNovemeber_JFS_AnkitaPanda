
public class Person {
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize method call");
	}
	public static void main(String[] args) throws Throwable {
		Person p1=new Person("Ak");
		p1.finalize();
	}

}
