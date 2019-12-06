
public class TestPerson extends Person {
	public TestPerson(String name) {
		super(name);
		
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("main method started");
		Person p1=new Person("Ankita");
		p1.finalize(); // we can call finalize()
		TestPerson p2=new TestPerson("Anki");
		p2.finalize();
		p1=null;
		System.gc(); //finalize() is call by garbage collector
		System.out.println("main ended");
	}

}
