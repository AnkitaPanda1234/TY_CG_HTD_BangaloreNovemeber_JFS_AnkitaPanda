import java.util.LinkedList;

public class LinkedList4 {
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.add(23);
		l1.add(65);
		l1.add(76);
		System.out.println("..push....");
		l1.push(45);
		System.out.println(l1);
		System.out.println("......pop......");
		l1.pop();
		System.out.println(l1);
		System.out.println("...Element.....");
		System.out.println(l1.element()); //get the first element and print it
		System.out.println(l1);
	}

}
