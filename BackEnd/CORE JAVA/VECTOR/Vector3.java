import java.util.Vector;

public class Vector3 {
	public static void main(String[] args) {
		Vector v1=new Vector();
		v1.addElement(65);
		v1.addElement(54);
		v1.addElement(34);
		v1.add(51);
		System.out.println(v1);
		System.out.println("remove element through object");
		v1.removeElement(new Integer(54));
		System.out.println(v1);
		System.out.println("remove element at particular index");
		v1.removeElementAt(2);
		System.out.println(v1);
		System.out.println("converting vector into a array");
		Object i1[]=new Object[v1.size()];

		v1.copyInto(i1);

		for(int i=0;i<i1.length;i++)
		{
			System.out.println(i1[1]);
		}

		Vector v2=new Vector();
		v2.addElement(34);
		v2.addElement(56);
		System.out.println("size and capacity");
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		System.out.println(".......trim to size.....");
		v2.trimToSize();
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		System.out.println("......ensure capacity....."); //defaultly take 6
		v2.ensureCapacity(6);
		v2.setSize(8);
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		System.out.println(v2);


	}

}
