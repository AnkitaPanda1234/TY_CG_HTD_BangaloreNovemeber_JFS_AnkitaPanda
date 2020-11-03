package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.AdminException;
@Repository
public class AdminDAOImpl implements AdminDAO {
@PersistenceUnit
private EntityManagerFactory factory;
	@Override
	public boolean clientregister(UserBean clientBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(clientBean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			throw new AdminException("username already exists");
		}
		
	}

	@Override
	public boolean schedulerregister(UserBean schedulerBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(schedulerBean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			throw new AdminException("username already exists");
		}
		
	}
	@Override
	public boolean removeClient(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		UserBean clientbean=manager.find(UserBean.class, id);
		if(clientbean !=null) {
			manager.remove(clientbean);
			transaction.commit();
			return true;
		}
		
		throw new AdminException("client account already exist");
	}

	@Override
	public List<UserBean> showClients() {
		String jpql="from UserBean where role='client'";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<UserBean> query=manager.createQuery(jpql,UserBean.class);
		if(query !=null) {
			return query.getResultList();
		}else {
			throw new AdminException("sorry no record found");
		}
	}

	@Override
	public boolean removeScheduler(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		UserBean schedulerBean=manager.find(UserBean.class, id);
		if(schedulerBean !=null) {
			manager.remove(schedulerBean);
			transaction.commit();
			return true;
		}
		
		throw new AdminException("client account already exist");
	}


	@Override
	public List<UserBean> showScheduler() {
		String jpql="from UserBean where role='scheduler'";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<UserBean> query=manager.createQuery(jpql,UserBean.class);
		if(query !=null) {
			
			return query.getResultList();
		}
		else {
			throw new AdminException("sorry no record found");
		}
		
	}


}
