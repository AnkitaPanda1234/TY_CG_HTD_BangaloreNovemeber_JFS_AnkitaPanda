import java.util.LinkedList;

public class LinkedList2 {
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.add(23);
		l1.add(34);
		System.out.println(l1);
		l1.addFirst(45);
		System.out.println(l1);
		l1.addLast(89);
		System.out.println(l1);
		System.out.println("...remove().......");
		l1.remove();
		System.out.println(l1);
		System.out.println("..remove first and remove last.......");
		l1.removeFirst();
		l1.removeLast();
		System.out.println(l1);
		
		LinkedList l2=new LinkedList();
		l2.add(10);
		l2.add(20);
		l2.add(30);
		l2.add(20);
		l2.removeFirstOccurrence(20);
		System.out.println(l2);
		l2.removeLastOccurrence(20);
		System.out.println(l2);
		System.out.println("get first and get last");
		System.out.println(l2.getFirst());
		System.out.println(l2.getLast());
		
		
	}

}
