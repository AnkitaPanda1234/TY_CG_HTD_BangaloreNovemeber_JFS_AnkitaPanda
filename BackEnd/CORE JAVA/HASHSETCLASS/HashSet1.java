import java.util.HashSet;

public class HashSet1 {
	public static void main(String[] args) {
	HashSet hs=new HashSet();
	
	hs.add(12);
	hs.add(23);
	hs.add(45);
	hs.add(67);
	hs.add(12);
	hs.add(null);
	for (Object object : hs) {
		System.out.println(object);
		
	}
	
	HashSet<String> h1=new HashSet<String>();
	 h1.add("ankita");
	 h1.add("subha");
	 h1.add("Ani");
	 h1.add(null);
	 
	 for (String string : h1) {
		 System.out.println(string);
		
	}
	}

}
