package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class UpdateDemo {
	public static void main(String[] args) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerfactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			Movie record=entityManager.find(Movie.class,101);
			record.setMoviename("dilll");
			record.setRating("good");
			System.out.println("Record sucessfully updated");
			transaction.commit();
			}
			  catch(Exception e)
			    {
				e.printStackTrace();
				transaction.rollback();
			    }
			
			entityManager.close();
		
	}

}
