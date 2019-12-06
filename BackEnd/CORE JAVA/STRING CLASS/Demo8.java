
public class Demo8 {
	public static void main(String[] args) {
		StringBuilder s1=new StringBuilder("Ankita");
		System.out.println(s1.hashCode());
		s1=s1.append("Panda");
		System.out.println(s1.hashCode());
	}

}
