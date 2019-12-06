package com.tyss.typecasting.pack2;

public class TestAnimal {

	public static void main(String[] args) {
		Animal a1=new Animal();
		a1.eat();
		System.out.println(".........");
		
		Animal a2=new Dog();    //upcasting
		  a2.eat();
		  System.out.println("........");
		 Dog d1=(Dog)a2;   //downcasting
		   d1.eat();
		   d1.walk();
		   System.out.println("........");
		   
		   Animal a3=new Lion();   //upcasting
				   a3.eat();
			Lion l1=(Lion)a3;    //downcasting
			l1.eat();
			l1.run();
				       
	}

}
