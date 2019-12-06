import java.util.Stack;

public class Stack1 {
	public static void main(String[] args) {
		Stack s1=new Stack();
		 s1.add(23);
		 s1.add(56);
		 s1.add(67);
		 s1.push(55);
		 System.out.println("....push()..."); //add element at last
		 System.out.println(s1);
		 System.out.println(".......pop()....."); //remove last element
		 s1.pop();
		 System.out.println(s1);
		 System.out.println(".....peek()..."); // peek last element and print it
		 System.out.println(s1.peek()); //
		 System.out.println(s1);
		 System.out.println(".....search()....."); //search in reverse order as 23 is present in 2nd position
		 System.out.println(s1.search(23));
		 System.out.println(s1);
	}

}
