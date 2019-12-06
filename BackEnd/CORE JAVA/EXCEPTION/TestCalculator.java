
public class TestCalculator {
	public static void main(String[] args) {
		System.out.println("main method started");
		Calculator c1=new Calculator();
		c1.divide(10, 0);  //Arithmetic Exception handelded by JVM
		System.out.println("main method ended");
		
	}

}
