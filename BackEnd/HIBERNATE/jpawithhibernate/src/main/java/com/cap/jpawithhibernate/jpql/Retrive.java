package com.cap.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cap.jpawithhibernate.dto.Movie;

public class Retrive {
	public static void main(String[] args) {
		
		
		EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerfactory.createEntityManager();
		//String jpql="from Movie";
		String jpql="select moviename from Movie";
		Query query=entityManager.createQuery(jpql);
		//List<Movie> record=query.getResultList();
		List<String> record=query.getResultList();
		/*for(Movie movie:record)
		{
			System.out.println("Movie id"+movie.getMovieid());
			System.out.println("Movie name"+movie.getMoviename());
			System.out.println("movie rating is"+movie.getRating());
		}*/
		for(String movie:record)
		{
			System.out.println(movie);
		}
		entityManager.close();
	}

}
