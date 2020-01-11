package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.ProductException;
@Repository
public class ProductDaoImpl  implements ProductDao{
@PersistenceUnit
private EntityManagerFactory factory;
	@Override
	public boolean addProduct(ProductBean bean) {
		EntityManager manager=factory.createEntityManager();//one per operation alws local
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
		manager.persist(bean);
		transaction.commit();
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ProductException("Customer Account  already exit");
			
		}
	}

	@Override
	public ProductBean getProduct(int productid) {
		String jpql="from ProductBean where productid=:productid";
		EntityManager manager=factory.createEntityManager();
		TypedQuery <ProductBean>query=manager.createQuery(jpql,ProductBean.class);
	   if(query!=null) {
	    query.setParameter("productid", productid);
		return query.getSingleResult();
	}
	throw new ProductException("product id Not found");
		
	}

	@Override
	public List<ProductBean> getAllProduct() {
		String jpql="from ProductBean";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<ProductBean> query=manager.createQuery(jpql,ProductBean.class);
		if(query!=null)
		{
		return query.getResultList();
		}
		throw new ProductException("no data found ");
	}

}
