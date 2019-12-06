
public class TestEmployee1 {
public static void main(String[] args) {
	Employee1 e1=new Employee1(11, "Ankita");
	Employee1 e2=new Employee1(11, "Ankita");
	System.out.println(e1.equals(e2));
	System.out.println(e1.hashCode());
	System.out.println(e2.hashCode()); //both hash code will be same because we are implmenting the 
	                                    //hash code() 
}
}
