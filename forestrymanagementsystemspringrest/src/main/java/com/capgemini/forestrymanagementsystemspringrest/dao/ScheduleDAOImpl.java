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

import com.capgemini.forestrymanagementsystemspringrest.dto.ScheduleBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.exception.SchedulerException;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addSchedule(ScheduleBean scheduleBean) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(scheduleBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new CustomerException("Scheduled Account  already exit");

		}
	}

	@Override
	public ScheduleBean searchSchedule(int scheduleId) throws NoResultException {

		String jpql = "from ScheduleBean where scheduleId=:scheduleId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ScheduleBean> query = manager.createQuery(jpql, ScheduleBean.class);

		ScheduleBean scheduleBean = null;
		query.setParameter("scheduleId", scheduleId);
		scheduleBean = query.getSingleResult();
		if (scheduleBean == null) {
			throw new CustomerException("Schedule not found for  id:" + scheduleId + " To View");
		} else {
			return scheduleBean;
		}

	}

	@Override
	public List<ScheduleBean> getAllSchedule() throws SchedulerException {
		String jpql = "from ScheduleBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ScheduleBean> query = manager.createQuery(jpql, ScheduleBean.class);
		List<ScheduleBean> schedulerList = null;
		schedulerList = query.getResultList();
		if (schedulerList.isEmpty()) {
			throw new CustomerException("Sorry,Currently There is no Contractor details found");
		} else {
			return schedulerList;
		}
	}

	@Override
	public boolean deleteSchedule(int scheduleId) throws SchedulerException {
		
		ScheduleBean scheduleBean = null;
		try {
			scheduleBean = searchSchedule(scheduleId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
		EntityTransaction transaction = null;
		if (scheduleBean != null) {

			EntityManager entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "Update ScheduleBean set status=:status " + "where scheduleId=:scheduleId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("status", "Cancelled");
			query.setParameter("scheduleId", scheduleId);
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

		} else {
			throw new CustomerException("Scheduler not found  To Update");
		}
	}

	/*@Override
	public boolean modifySchedule(int scheduleId, String status) throws SchedulerException {

		ScheduleBean scheduleBean = null;
		try {
			scheduleBean = searchSchedule(scheduleId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
		EntityTransaction transaction = null;
		if (scheduleBean != null) {

			EntityManager entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "Update ScheduleBean set status=:status " + "where scheduleId=:scheduleId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("status", status);
			query.setParameter("scheduleId", scheduleId);
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

		} else {
			throw new CustomerException("Scheduler not found  To Update");
		}

	}*/

	

}
