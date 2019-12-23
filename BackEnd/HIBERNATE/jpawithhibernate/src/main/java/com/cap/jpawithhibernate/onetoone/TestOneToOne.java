package com.cap.jpawithhibernate.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToOne {
	public static void main(String[] args) {
		//for unidirectional
		/*Employee employee=new Employee();
		employee.setEid(11);
		employee.setEname("Ankita");
		employee.setEmail("ankita@gmail.com");
		employee.setPassword("ankita12");
		
		EmployeeOtherInfo other=new EmployeeOtherInfo();
		     other.setId(12);
		     other.setPancard("abc123");
		     other.setFname("ram");
		     other.setMname("mita");
		     other.setEmployee(employee);*/
		//forbidirectional
		      
		
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
		EntityManagerFactory entityManagerfactory=Persistence.createEntityManagerFactory("Test");
		entityManager=entityManagerfactory.createEntityManager();
		transaction=entityManager.getTransaction(); //connect with database
		transaction.begin();
		Employee emp=entityManager.find(Employee.class, 10);
		   System.out.println( emp.getOther().getMname());
		//entityManager.persist(other);
		System.out.println("Record sucessfully inserted");
		transaction.commit(); //it will effect database
		}
		  catch(Exception e)
		    {
			e.printStackTrace();
			transaction.rollback();
		    }
		
		entityManager.close();
	}

}
