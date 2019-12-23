package com.cap.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerfactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String jpql="Delete Movie  where movieid=11";
		Query query=entityManager.createQuery(jpql);
		query.executeUpdate();
		transaction.commit();
		entityManager.close();
		
		
	}

}
