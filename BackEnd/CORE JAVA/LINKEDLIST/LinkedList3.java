import java.util.LinkedList;

public class LinkedList3 {
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.add(23);
		l1.add(65);
		l1.add(76);
		l1.add(43);
		System.out.println("...peek and peekfirst and peeklast");
		System.out.println(l1.peek());
		System.out.println(l1.peekFirst());
		System.out.println(l1.peekLast());
		System.out.println(l1);
		
		System.out.println("..poll and pollfirst and pollLast...");
		System.out.println(l1.poll());
		System.out.println(l1);
		System.out.println(l1.pollFirst());
		System.out.println(l1);
		System.out.println(l1.pollLast());
		System.out.println(l1);
		
		LinkedList l2=new LinkedList();
		l2.add(23);
		l2.add(65);
		l2.add(76);
		l2.add(43);
		System.out.println("..offer afferfirst and offerlast..");
		System.out.println(l2.offer(12));
		System.out.println(l2);
		System.out.println(l2.offerFirst(34));
		System.out.println(l2);
		System.out.println(l2.offerLast(90));
		System.out.println(l2);
	}

}
