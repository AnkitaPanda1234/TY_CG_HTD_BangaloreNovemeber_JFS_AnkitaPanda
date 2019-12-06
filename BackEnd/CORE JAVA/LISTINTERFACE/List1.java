import java.util.ArrayList;
import java.util.List;

public class List1 {
	public static void main(String[] args) {
		List l1=new ArrayList();
		//methods present in List
		System.out.println("Add all");
		l1.add(0,12);
		l1.add(1,13);
		l1.add(2,14);
		l1.add(3,15);
		l1.add(4,16);
		l1.add(5,19);
		System.out.println(l1);
		System.out.println("Remove all");
		l1.remove(1);
		System.out.println(l1);
		System.out.println(l1.indexOf(16));
		
		l1.add(16);
		System.out.println(l1);
		System.out.println(l1.lastIndexOf(16));
		System.out.println("............");
		for(int i=0;i<l1.size();i++)
		{
			System.out.println(l1.get(i));
		}
		List l2=new ArrayList();
		l2.add(20);
		l2.add(30);
		System.out.println(l1.addAll(l2));
		System.out.println(l1);
		
		List l3=new ArrayList();
		l3.add(90);
		l3.add(100);
		l3.add(110);
		l3.set(1, 1000);
		System.out.println(l3);
		
		List l4=new ArrayList();
		l4.add(28);
		l4.add(87);
		l4.add(98);
		List l5=l4.subList(0, 2);
		System.out.println(l5);
	}

}
