import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.add(2);
		l1.add(4);
		l1.add(22);
		l1.add(36);
		
		ListIterator ltr=l1.listIterator();
		while(ltr.hasNext())
		{
			System.out.println(ltr.next());
		}
		l1.add(2);
		l1.add(null);  //linkedlist can take null value 
		System.out.println(l1);
		l1.remove(new Integer(2));
		System.out.println(l1);
		System.out.println("....for each loop....");
		for( Object i1 :l1)
		{
			System.out.println(i1);
		}
		System.out.println("......for loop.....");
		for(int i=0;i<l1.size();i++)
				{
			System.out.println(l1.get(i));
				}
	}

}
