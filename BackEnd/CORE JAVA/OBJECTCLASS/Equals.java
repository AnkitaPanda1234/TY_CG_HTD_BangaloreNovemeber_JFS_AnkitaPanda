
public class Equals {
	public static void main(String[] args) {
		String s1="Ankita";
		String s2="Ankita";
		String s3=new String("Ankita");
		System.out.println(s1.equals(s2));  //acc. equals method 
		System.out.println(s1==s2); //acc. hashcode
		System.out.println(s1==s3); //acc. hashcode
	}

}
