
public class TestException {
	public static void main(String[] args) {
		System.out.println("main started");
		
		Exception e1=new Exception();
		e1.exception(0, "ramu");
		e1.exception(2, null);
		System.out.println("main ended");
		
	}

}
