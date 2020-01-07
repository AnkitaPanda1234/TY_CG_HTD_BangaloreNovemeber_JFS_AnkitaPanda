package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=
        		  new ClassPathXmlApplicationContext("beans.xml");
        
        Hello hello1=context.getBean(Hello.class);
        Hello hello2=context.getBean(Hello.class);
        System.out.println("................");
        System.out.println(hello1==hello2);
        System.out.println(".....................");
        System.out.println("........................");
        System.out.println(hello1);
        System.out.println(hello2);
        
        System.out.println(hello1.getMessage());
        System.out.println(hello1.getCount());
        
        System.out.println("*********************************");
        Animal animal=context.getBean(Animal.class);//dependency alws goes to interface
        //getBean() is the factory method
        animal.makeSound();
        System.out.println("*********for pet************");
        Pet pet=context.getBean(Pet.class);
        System.out.println(pet.getName());
        pet.getAnimal().makeSound();
    }
}
