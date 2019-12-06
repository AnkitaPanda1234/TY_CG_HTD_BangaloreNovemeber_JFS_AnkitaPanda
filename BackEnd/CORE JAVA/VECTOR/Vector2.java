import java.util.Vector;

public class Vector2 {
	public static void main(String[] args) {
		Vector v1=new Vector();
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.add(12);
		v1.add(34);
		v1.add(76);
		v1.add(83);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println("..trim to size()..");
		v1.trimToSize();
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println("..set size()....");
		v1.setSize(10);
		System.out.println(v1.size());
		System.out.println(v1);
		v1.add(200);
		System.out.println(v1.size());
		System.out.println(v1);
		v1.set(5,890);
		System.out.println(v1);
		
	}

}
