package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class ReadDemo {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Movie record=entityManager.find(Movie.class,101);
		System.out.println("The data that you want to retrive is");
		System.out.println("id is.."+record.getMovieid());
		System.out.println("name is.."+record.getMoviename());
		System.out.println("rating is.."+record.getRating());
		
		entityManager.close();	
		
	} //end of main method

} //end of class
