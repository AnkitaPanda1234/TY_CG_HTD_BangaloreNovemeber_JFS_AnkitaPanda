package com.cap.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdate {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerfactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String jpql="update Movie set moviename=:mname where movieid=:mid";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("mid", 102);
		query.setParameter("mname", "Dill");
		int result=query.executeUpdate();
		System.out.println(result);
		transaction.commit();
		entityManager.close();
		
	}

}
