import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet1 {
	public static void main(String[] args) {
		LinkedHashSet l1=new LinkedHashSet();
		//non generic type
		l1.add(12);
		l1.add(23);
		l1.add(87);
		l1.add(12);
		
		Iterator itr=l1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
				
				//Generic type of integer
				System.out.println("generic type");
				
				LinkedHashSet <Integer>l2=new LinkedHashSet<Integer>();
				l2.add(67);
				l2.add(78);
				l2.add(65);
				l2.add(null);
				Iterator it=l2.iterator();
				while (it.hasNext())
				{
					System.out.println(it.next());
				}
				
	}

}
