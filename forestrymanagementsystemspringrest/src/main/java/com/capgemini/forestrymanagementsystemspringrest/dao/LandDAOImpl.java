package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.exception.LandException;

@Repository
public class LandDAOImpl implements LandDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addLandDetails(LandBean land) {
		EntityManager manager = factory.createEntityManager();// one per operation alws local
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(land);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new LandException("Land Details  already exit");

		}
	}

	@Override
	public boolean deleteLandDetails(int landid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		LandBean landBean = null;
		try {
			landBean = manager.find(LandBean.class, landid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (landBean == null) {
			throw new CustomerException("Land With  Id:" + landid + " Not Present To Delete");
		} else {
			manager.remove(landBean);
			transaction.commit();
			return true;
		}
	}

	@Override
	public boolean updateLandDeatails(int landid, long landvalue) {
		EntityTransaction transaction = null;

		LandBean landBean = null;
		try {
			landBean = viewLandDetails(landid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (landBean == null) {
			throw new CustomerException("Land not found for landid id:" + landid + " To Update");
		} else {

			EntityManager entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "Update LandBean set landvalue=:landvalue " + "where landid=:landid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("landvalue", landvalue);
			query.setParameter("landid", landid);
			@SuppressWarnings("unused")
			int result = query.executeUpdate();
			transaction.commit();
			entityManager.close();
			if (result > 0) {
				return true;
			} else {
				if (transaction != null) {
					transaction.rollback();
				}
				return false;
			}
		}

	}

	@Override
	public List<LandBean> showLandDetails() {
		String jpql = "from LandBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LandBean> query = manager.createQuery(jpql, LandBean.class);

		List<LandBean> landList = null;
		landList = query.getResultList();
		if (landList.isEmpty()) {
			throw new CustomerException("Sorry,Currently There is no land details found");
		} else {
			return landList;
		}

	}

	@Override
	public LandBean viewLandDetails(int landid) {
		String jpql = "from LandBean where landid=:landid";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LandBean> query = manager.createQuery(jpql, LandBean.class);
		query.setParameter("landid", landid);
		LandBean landBean = null;
		landBean = query.getSingleResult();
		if (landBean == null) {
			throw new CustomerException("Land not found for landid id:" + landid + " To View");
		} else {
			return landBean;
		}

	}
}
