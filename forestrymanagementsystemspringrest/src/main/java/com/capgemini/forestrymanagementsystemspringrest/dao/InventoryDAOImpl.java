package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.exception.InventoryException;

@Repository
public class InventoryDAOImpl implements InventoryDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addInventory(InventoryBean bean) {

		EntityManager manager = factory.createEntityManager();// one per operation alws local
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new CustomerException("Product already exit");

		}
	}

	@Override
	public boolean deleteInventory(int productid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		InventoryBean inventoryBean = null;
		try {
			inventoryBean = manager.find(InventoryBean.class, productid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (inventoryBean == null) {
			throw new CustomerException("Product With Product Id:" + productid + " Not Present To Delete");
		} else {
			manager.remove(inventoryBean);
			transaction.commit();
			return true;
		}
	}

	@Override
	public List<InventoryBean> getAllInventory() {
		String jpql = "from InventoryBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<InventoryBean> query = manager.createQuery(jpql, InventoryBean.class);
		List<InventoryBean> productList = null;
		productList = query.getResultList();
		if (productList.isEmpty()) {
			throw new CustomerException("Sorry,Currently There is no Product details found");
		} else {
			return productList;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public boolean modifyInventory(int productid, InventoryBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		InventoryBean inventorybean = null;
		try {
			inventorybean = manager.find(InventoryBean.class, productid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
		if (inventorybean == null) {
			transaction.rollback();
			throw new CustomerException("Product not found for Paroduct id:" + productid + " To Update");
		} else {
			inventorybean.setProductname(bean.getProductname());
			inventorybean.setProductquantity(bean.getProductquantity());
			transaction.commit();
			return true;
		}

	}

	@Override

	public InventoryBean getInventory(int productid) throws NoResultException {
		String jpql = "from InventoryBean where productid=:productid";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<InventoryBean> query = manager.createQuery(jpql, InventoryBean.class);

		InventoryBean inventoryBean = null;
		query.setParameter("productid", productid);
		inventoryBean = query.getSingleResult();
		if (inventoryBean == null) {
			throw new CustomerException("Product not found for Paroduct id:" + productid + " To View");
		} else {
			return inventoryBean;
		}

	}
}
