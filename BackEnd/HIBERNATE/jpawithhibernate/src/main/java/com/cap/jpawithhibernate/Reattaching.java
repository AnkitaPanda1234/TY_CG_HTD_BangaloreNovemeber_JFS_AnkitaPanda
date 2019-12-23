package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class Reattaching {
	public static void main(String[] args) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerfactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			Movie record=entityManager.find(Movie.class,118);
			System.out.println(entityManager.contains(record));
			entityManager.detach(record);
			System.out.println(entityManager.contains(record));
			Movie reattached=entityManager.merge(record);
			reattached.setMoviename("KKKH");
			reattached.setRating("good");
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
