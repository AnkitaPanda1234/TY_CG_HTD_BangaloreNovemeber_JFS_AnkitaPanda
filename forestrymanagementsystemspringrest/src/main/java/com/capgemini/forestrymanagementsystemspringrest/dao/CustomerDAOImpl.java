package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addCustomer(CustomerBean customer) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(customer);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new CustomerException("Customer Details Already Present");

		}
	}

	@Override
	public boolean deleteCustomer(int customerid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		CustomerBean customerBean = null;
		try {
			customerBean = manager.find(CustomerBean.class, customerid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (customerBean == null) {
			throw new CustomerException("Customer With  Id:" + customerid + " Not Present To Delete");
		} else {
			manager.remove(customerBean);
			transaction.commit();
			return true;
		}

	}

	@Override
	public List<CustomerBean> getAllCustomer() {
		String jpql = "from CustomerBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<CustomerBean> query = manager.createQuery(jpql, CustomerBean.class);
		List<CustomerBean> customerList = null;
		customerList = query.getResultList();
		if (customerList.isEmpty()) {
			throw new CustomerException("Sorry,Currently There is no Customer details found");
		} else {
			return customerList;
		}
	}

	@Override
	public boolean modifyCustomer(int customerid, CustomerBean customer) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		CustomerBean customerBean = null;
		try {
			customerBean = manager.find(CustomerBean.class, customerid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
		if (customerBean == null) {
			transaction.rollback();
			throw new CustomerException("Customer With  id:" + customerid + " Not Present");
		} else {

			customerBean.setCustomerName(customer.getCustomerName());
			customerBean.setEmail(customer.getEmail());
			customerBean.setPostalCode(customer.getPostalCode());
			customerBean.setStreetAddress1(customer.getStreetAddress1());
			customerBean.setTelephoneNum(customer.getTelephoneNum());
			customerBean.setTown(customer.getTown());
			transaction.commit();
			return true;
		}
	}

	@Override
	public CustomerBean getCustomer(int customerid) throws NoResultException {
		String jpql = "from CustomerBean where customerid=:customerid";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<CustomerBean> query = manager.createQuery(jpql, CustomerBean.class);

		CustomerBean customerBean = null;
		query.setParameter("customerid", customerid);

		customerBean = query.getSingleResult();
		if (customerBean == null) {
			throw new CustomerException("Customer not found for Paroduct id:" + customerid + " To View");
		} else {
			return customerBean;
		}
	}

}
