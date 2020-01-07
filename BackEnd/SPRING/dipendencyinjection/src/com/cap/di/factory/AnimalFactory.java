package com.cap.di.factory;

import com.cap.di.dao.Animal;
import com.cap.di.dao.Dog;

public class AnimalFactory {
	private AnimalFactory(){}
	
	public static Animal getAnimal()
	{
		return new Dog();
	}

}
