import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList2 {
	public static void main(String[] args) {
		ArrayList<String> a1=new ArrayList<String>();
		
		a1.add(0,"Ankita");
		a1.add(1,"pallavi");
		a1.add(2,"Diksha");
		a1.add(3,"Subha");
		a1.add(4,"Sonali");
		System.out.println(a1);
		
		a1.remove("Ankita");
		System.out.println(a1);
		System.out.println(a1.indexOf("Subha"));
		a1.add("Sonali");
		
		System.out.println(a1.lastIndexOf("Sonali"));
		
		for(int i=0;i<a1.size();i++)
		{
			System.out.println(a1.get(i));
		}
		ArrayList<String> a2=new ArrayList<String>();
		a2.add("lori");
		a2.add("ani");
		a2.add("anu");
		System.out.println(a1.addAll(a2));
		System.out.println(a1);
		
		ArrayList<String> a3=new ArrayList<String>();
		a3.add("rusi");
		a3.add("Sima");
		a3.set(1, "mama");
		System.out.println(a3);
		ArrayList<String> a4=new ArrayList<String>();
		a4.add("aki");
		a4.add("susri");
		a4.add("Anim");
		System.out.println(a4.subList(0,2));
		System.out.println(".....for loop...");
		for(int i=0;i<a1.size();i++)
		{
			System.out.println(a1.get(i));
		}
		System.out.println("....iterator....");
		Iterator<String> itr =a1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("....list iterator....");
		ListIterator<String> itr1=a1.listIterator(a1.size());
		while(itr1.hasPrevious())
		{
			System.out.println(itr1.previous());
		}
	}

}
