package com.tyss.queue.priorityQueue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDeque1 {
	public static void main(String[] args) {
		ArrayDeque <String>a1=new ArrayDeque<String>();
		  a1.add("pallabi");
		  a1.add("Ankita");
		  a1.addFirst("ranu");
		  a1.add("soma");
		  a1.addLast("Diksha");
		  a1.add("sumi");
		  a1.add("sital");
		  
		  System.out.println(a1.getFirst());
		  System.out.println(a1.getLast());
		  a1.remove();
		  a1.removeFirst();
		  a1.removeLast();
		  System.out.println(a1);
		  a1.removeFirstOccurrence("ranu");
		  a1.removeLastOccurrence("ranu");
		  System.out.println(a1);
		  a1.peek();
		  a1.peekFirst();
		  a1.peekLast();
		  System.out.println(a1);
		  
		  a1.poll();
		  a1.pollFirst();
		  a1.pollLast();
		  System.out.println(a1);
		  
		  a1.offer("ranu");
		  a1.offerFirst("pinki");
		  a1.offerLast("mama");
		  System.out.println(a1);
		  a1.push("sima");
		  a1.pop();
		  a1.element();
		  System.out.println(a1);
		  
		  System.out.println("..iteration......");
		  Iterator itr=a1.iterator();
		  while(itr.hasNext())
		  {
			  System.out.println(itr.next());
		  }
		  
	}

}
