package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.OrderException;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.ProductException;
@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addOrder(OrderBean order) {
		EntityManager manager=factory.createEntityManager();//one per operation alws local
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
		manager.persist(order);
		transaction.commit();
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ProductException("Order Account  already exit");
			
		}
	}
		
	@Override
	public OrderBean getOrder(int orderid) {
		String jpql="from OrderBean where orderid=:orderid";
		EntityManager manager=factory.createEntityManager();
		TypedQuery <OrderBean>query=manager.createQuery(jpql,OrderBean.class);
	     if(query!=null) {
	    query.setParameter("orderid", orderid);
		return query.getSingleResult();
	}
	throw new OrderException("order id Not found");
		
	}

	@Override
	public List<OrderBean> getAllOrder() {
		String jpql="from OrderBean";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<OrderBean> query=manager.createQuery(jpql,OrderBean.class);
		if(query!=null)
		{
		return query.getResultList();
		}
		throw new OrderException("no data found ");
	}


}
