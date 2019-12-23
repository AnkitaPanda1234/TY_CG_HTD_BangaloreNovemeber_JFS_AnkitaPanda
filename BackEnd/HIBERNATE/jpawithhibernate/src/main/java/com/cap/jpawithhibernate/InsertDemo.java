package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class InsertDemo {

	public static void main(String[] args) {
		Movie movie=new Movie();
		movie.setMovieid(119);
		movie.setMoviename("ABCD");
		movie.setRating("Good");
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
		EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
		entityManager=entityManagerfactory.createEntityManager();
		transaction=entityManager.getTransaction(); //connect with database
		transaction.begin();
		entityManager.persist(movie);
		System.out.println("Record sucessfully inserted");
		transaction.commit(); //it will effect database
		}
		  catch(Exception e)
		    {
			e.printStackTrace();
			transaction.rollback();
		    }
		
		entityManager.close();

	}//end of main

} //end of class
