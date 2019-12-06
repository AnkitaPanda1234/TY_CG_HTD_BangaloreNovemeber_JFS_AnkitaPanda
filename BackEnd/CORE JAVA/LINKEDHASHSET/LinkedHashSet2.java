import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet2 {
	public static void main(String[] args) {
		LinkedHashSet <Employee>l1=new LinkedHashSet<Employee>();
		l1.add(new Employee(22,"Ankita"));
		l1.add(new Employee(20,"acd"));
		l1.add(new Employee(22,"Ankita"));  //can't add duplicate value bcoz we override equals and hashcode
		
		Iterator<Employee> itr=l1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		
		
	}

}
