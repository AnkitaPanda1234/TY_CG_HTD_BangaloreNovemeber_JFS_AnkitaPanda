import java.util.ArrayList;
import java.util.Collection;

public class Collection3 {
	public static void main(String[] args) {
		Collection c1=new ArrayList();
		c1.add(12);
		c1.add(13);
		c1.add(14);
		c1.add(15);
		Collection c2=new ArrayList();
		c2.add(16);
		c2.add(17);
		c2.add(18);
		c2.add(19);
		c1.addAll(c2);
		System.out.println(c1);
		System.out.println("Add all completed");
		Collection c3=new ArrayList();
		c3.add(20);
		c3.add(30);
		c3.add(40);
		c3.add(50);
		Collection c4=new ArrayList();
		c4.add(40);
		c4.add(50);
		c4.add(60);
		c4.add(70);
		c3.removeAll(c4);
		System.out.println(c3);
		System.out.println("remove all completed");
		Collection c5=new ArrayList();
		c5.add(25);
		c5.add(23);
		c5.add(86);
		c5.add(98);
		Collection c6=new ArrayList();
		c6.add(25);
		c6.add(23);
		c6.add(12);
		c6.add(13);
		System.out.println(c5);
		c5.retainAll(c6);
		System.out.println(c5);
		System.out.println("retain all ");
		System.out.println(c5);
		System.out.println(c5.containsAll(c6));
		
		System.out.println(c5);
		c5.clear();
		System.out.println("clear all");
		
		Collection c7=new ArrayList();
		c7.add(45);
		c7.add(67);
		Object a[]=c7.toArray();
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
