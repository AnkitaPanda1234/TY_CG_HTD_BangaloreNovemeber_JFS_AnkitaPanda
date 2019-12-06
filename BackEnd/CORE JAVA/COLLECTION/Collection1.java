import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
	public static void main(String[] args) {
		Collection c1=new ArrayList();
		
		//adding an element inside the collection
		c1.add(13);
		System.out.println(c1);
		// removing the element from the collection
		c1.remove(13);
		System.out.println(c1);
		//finding the size of the collection
		System.out.println(c1.size());
		//checking than collection is emptyor nor
		System.out.println(c1.isEmpty());
		c1.add(13);
		//checking whether 13 object isthere or not inside the collection
		System.out.println(c1.contains(13));
		
	}

}
