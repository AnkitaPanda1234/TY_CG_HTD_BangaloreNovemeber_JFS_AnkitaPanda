package com.capgemini.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

@Configuration
public class BeansConfig {
	@Bean("hello") //config that class as bean where hello is the name of bean
	@Scope("prototype")//it is not present inside bean it is a another scope
	public Hello  getHello()
	{
		Hello hello=new Hello();
		hello.setMessage("I Love C");
		hello.setCount(1000);
		return hello;
	}
	@Bean( name="dog") //we can use another function alse
   public Dog getDog() //by default method name will be the name of bean
   {
	   return new Dog();
   }
	
	
	@Bean("cat")
	@Primary //as we dont have the scope primary=true we explictly use primary annotation
	public Cat getCat()
	{
		return new Cat();
	}
	@Bean("pet")
	public Pet getPet()
	{
		Pet pet=new Pet();
		pet.setName("Tufy");
		//pet.setAnimal(getDog()); as we use autowired in pet class
		return pet;
	}
}
