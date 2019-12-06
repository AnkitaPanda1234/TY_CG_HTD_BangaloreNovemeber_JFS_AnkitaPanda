
public class Demo2 {
	public static void main(String[] args) {
		String s1=new String("john");
		System.out.println(s1.hashCode());
		
		String s2=new String("mikel");
		String s3=new String("john");
		
		        s1=new String("divya");
		        System.out.println(s1.hashCode()); // different with s1.hashcode()
		        System.out.println(s3.hashCode()); //same as 1st s1.hashcode()
		        System.out.println(s2.hashCode());
		        
	}

}
