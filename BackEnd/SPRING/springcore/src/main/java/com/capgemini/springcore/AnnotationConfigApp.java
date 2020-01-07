package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;
import com.capgemini.springcore.config.BeansConfig;

public class AnnotationConfigApp {
	public static void main(String[] args) {
		ApplicationContext context=
			new AnnotationConfigApplicationContext(BeansConfig.class);
		System.out.println(".........achiveing Bean............");
		Hello hello1=context.getBean(Hello.class); //creating object of bean using annotation
		System.out.println(hello1.getMessage());
		System.out.println(hello1.getCount());
		System.out.println("......................");
		
		System.out.println("....... scope using for two object...........");
		Hello hello2=context.getBean(Hello.class);
		System.out.println(hello1);
		System.out.println(hello2);
		System.out.println(hello1==hello2);
		
		
		
		System.out.println("....... dependency injection..........");
		
		Animal animal=context.getBean(Animal.class);
		animal.makeSound();
		System.out.println("........Use wire.........");
		Pet pet=context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound(); //still its working bcoz we use @Autowired
		
		
	}

}
