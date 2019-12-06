
public class TestAnimal {

	public static void main(String[] args) {
		Lion l1=new Lion();
				l1.eat();
		Cat c1=new Cat();		
		      c1.eat();
		      
		      Animal a1=new Lion();///Up Casting always go for the reference type
		             a1.eat();
		             
		             
		             Animal a2=new Cat();
		                    a2.eat();
		             
	}

}
