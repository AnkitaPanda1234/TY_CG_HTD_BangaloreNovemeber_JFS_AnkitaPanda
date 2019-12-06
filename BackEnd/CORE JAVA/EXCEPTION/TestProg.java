package throwkey;

public class TestProg {
	public static void main(String[] args) {
		System.out.println("main started");
		GoogleMap g1=new GoogleMap();
		  Ola o1=new Ola(g1);
		  o1.find(null);
		  System.out.println("main ended");
	}

}
