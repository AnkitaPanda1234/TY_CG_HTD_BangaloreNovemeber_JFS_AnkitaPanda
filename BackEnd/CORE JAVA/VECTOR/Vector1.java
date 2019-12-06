import java.util.Vector;

public class Vector1 {
	public static void main(String[] args) {
		Vector v1=new Vector();
		v1.add(12);
		v1.add(34);
		v1.add(65);
		v1.add(87);
		System.out.println(v1);
		System.out.println("..remove...");
		v1.remove(new Integer(34));
		System.out.println(v1);
		
		System.out.println(v1.set(1,22));
		System.out.println(v1);
		System.out.println(".....for loop.....");
		for(int i=0;i<v1.size();i++)
		{
			System.out.println(v1.get(i));
		}
	}

}
