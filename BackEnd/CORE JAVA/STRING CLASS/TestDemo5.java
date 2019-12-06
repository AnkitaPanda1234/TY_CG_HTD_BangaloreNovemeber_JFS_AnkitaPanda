
public class TestDemo5 {
	public static void main(String[] args) {
		Demo5 d1=new Demo5("john",23);
		System.out.println(d1.hashCode());
		int age=d1.getage();
		String name=d1.getname();
		System.out.println("age is" +age);
		System.out.println("name is "+name);
		
	 d1=new Demo5("Mikel",24);
	 System.out.println(d1.hashCode());
	}

}
