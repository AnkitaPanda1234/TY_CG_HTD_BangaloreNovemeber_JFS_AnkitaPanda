package com.tyss.jpawithhibernate.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.onetoone.Employee;

public class TestManyToMany {
	public static void main(String[] args) {
		Employee employee=new Employee();
		     employee.setEid(16);
		     employee.setEname("sonu");
		     employee.setEmail("sonu@gmail.com");
		     employee.setPassword("sonu12");
		     
		     Employee employee1=new Employee();
		     employee1.setEid(38);
		     employee1.setEname("sima");
		     employee1.setEmail("sima@gmail.com");
		     employee1.setPassword("sima12");
		     ArrayList<Employee> alist=new ArrayList<Employee>();
		              alist.add(employee);
		              alist.add(employee1);
		              TrainingInfo tinfo=new TrainingInfo();
		                tinfo.setTid(67);
		                tinfo.setTname("aaa");
		               tinfo.setElist(alist);
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerfactory.createEntityManager();
			transaction=entityManager.getTransaction(); //connect with database
			transaction.begin();
			entityManager.persist(tinfo);
			
			System.out.println("Record sucessfully inserted");
			transaction.commit(); //it will effect database
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//transaction.rollback();
		}

		entityManager.close();
	}
		
	}


