package com.cap.jpawithhibernate.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.onetoone.Employee;

public class TestManyToOne {
	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setEid(34);
		emp.setEname("Ankita");
		emp.setEmail("ankita@gmail.com");
		emp.setPassword("ankita12");

		EmployeeExperence exp1=new EmployeeExperence();
		exp1.setExp_id(56);
		exp1.setCompname("TCS");
		exp1.setDuration(98);
		exp1.setEmployee(emp);

		EmployeeExperence experence2=new EmployeeExperence();
		experence2.setExp_id(536);
		experence2.setCompname("HCL");
	 	experence2.setDuration(34);
		experence2.setEmployee(emp);


		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerfactory.createEntityManager();
			transaction=entityManager.getTransaction(); //connect with database
			transaction.begin();
			entityManager.persist(exp1);
			entityManager.persist(experence2);
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



