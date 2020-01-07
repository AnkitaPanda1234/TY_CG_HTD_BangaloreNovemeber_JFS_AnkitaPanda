package com.cap.di;

import com.cap.di.dao.Animal;
import com.cap.di.factory.AnimalFactory;

public class App {
	public static void main(String[] args) {
		Animal animal=AnimalFactory.getAnimal(); //injecting the dependency of dog into class App
		animal.makeSound();
	}

}
