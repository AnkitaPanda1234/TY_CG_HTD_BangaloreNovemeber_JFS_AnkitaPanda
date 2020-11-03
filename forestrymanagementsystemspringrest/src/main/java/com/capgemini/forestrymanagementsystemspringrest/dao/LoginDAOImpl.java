package com.capgemini.forestrymanagementsystemspringrest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.ClientException;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;

@Repository

public class LoginDAOImpl implements LoginDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	public UserBean viewUserDetails(String username) {
		String jpql = "from UserBean where username=:username";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		query.setParameter("username", username);
		UserBean userBean = null;
		userBean = query.getSingleResult();
		if (userBean == null) {
			throw new CustomerException("username not found for landid id:" + username + " To View");
		} else {
			return userBean;
		}

	}
	public UserBean login(String username, String password) {
		EntityManager manager = factory.createEntityManager();
		
		UserBean userBean = null;
		try {
			userBean = viewUserDetails(username);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		if (userBean == null) {
			throw new CustomerException("username With  Id:" + username + " Not Present ");
		} else {
			String passwordFromDB = userBean.getPassword();
			System.out.println("passwordFromDB==>"+passwordFromDB);
			System.out.println("password given==>"+password);
			if (passwordFromDB.equalsIgnoreCase(password)) {
				manager.close();
				return userBean;
			} else {
				manager.close();
				return null;
			}
			
		}

	}

	/*
	 * @Override public UserBean clientlogin(String username, String password) {
	 * EntityManager manager = factory.createEntityManager(); String login =
	 * "from UserBean where role=:role and username=:username"; Query query=
	 * manager.createQuery(login); query.setParameter("role", "client");
	 * query.setParameter("username",username); try { UserBean client=(UserBean)
	 * query.getSingleResult(); if(client.getPassword().equals(password)) { return
	 * client; } return null; }catch(Exception e) { throw new
	 * ClientException("Client Account Does Not Exit"); } }
	 * 
	 * @Override public UserBean schedulerlogin(String username, String password) {
	 * EntityManager manager = factory.createEntityManager(); String login =
	 * "from UserBean where role=:role and username=:username"; Query query=
	 * manager.createQuery(login); query.setParameter("role", "scheduler");
	 * query.setParameter("username",username); try { UserBean scheduler=(UserBean)
	 * query.getSingleResult(); if(scheduler.getPassword().equals(password)) {
	 * return scheduler; } return null; }catch(Exception e) { throw new
	 * ForestryUserException("Scheduler Account Does Not Exit"); } }
	 */

}
