import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestB {
	public static void main(String[] args) {
		ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(78);
		a1.add(23);
		a1.add(56);
		a1.add(29);
		a1.add(90);
		a1.add(89);
		List<Integer> l1=a1.stream().filter(i -> i%2==0).collect(Collectors.toList()); //even
		List<Integer> l2=a1.stream().filter(i -> i%2!=0).collect(Collectors.toList()); //odd
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(".....Map....");	
		List<Integer> l3=a1.stream().map(i -> i*100).collect(Collectors.toList());
		System.out.println(l3);
		
		System.out.println("...max value......");
		Optional<Integer> a=a1.stream().max((i,j)-> i.compareTo(j)); //max value
		System.out.println(a);
		System.out.println("how many array present ? ");
		System.out.println(a1.stream().count());
	}

}
