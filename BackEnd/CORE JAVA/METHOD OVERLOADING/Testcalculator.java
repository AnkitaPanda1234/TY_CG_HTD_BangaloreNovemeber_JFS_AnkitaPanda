
public  class Testcalculator {

	public static void main(String[] args) {
		Calculator c1=new Calculator();
		int r1=c1.add(12);
		System.out.println("result is"+r1);
		
		int r2=c1.add(12, 12);
		System.out.println("result is"+r2);
		
		double r3=c1.add(12.3);
		System.out.println("result is"+r3);
		
		
		Calculator.multiply(12);
		Calculator.multiply(12, 4);
		Calculator.multiply(3.4);
		
	}

}
