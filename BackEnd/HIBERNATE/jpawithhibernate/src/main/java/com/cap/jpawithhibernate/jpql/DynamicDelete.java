package com.cap.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicDelete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerfactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String jpql="delete from Movie  where movieid=:mid";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("mid", 102);
		int result=query.executeUpdate();
		System.out.println(result);
		transaction.commit();
		entityManager.close();
		
	}


}
