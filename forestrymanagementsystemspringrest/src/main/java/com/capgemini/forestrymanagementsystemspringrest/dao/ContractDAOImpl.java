package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementsystemspringrest.dto.ContractBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.ContractorException;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.service.InventoryService;
import com.capgemini.forestrymanagementsystemspringrest.service.InventoryServiceImpl;

@Repository
public class ContractDAOImpl implements ContractDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	InventoryService inventoryServices = new InventoryServiceImpl();

	@Override
	public boolean addContract(ContractBean bean) {
		EntityManager manager = factory.createEntityManager();// one per operation alws local
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		try {
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new ContractorException("Contract Account already Present");

		}
	}

	@SuppressWarnings("null")
	@Override
	public boolean deleteContract(int contractId) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		ContractBean contractBean = null;
		try {
			contractBean = manager.find(ContractBean.class, contractId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (contractBean == null) {
			transaction.rollback();
			throw new CustomerException("Contract With  Id:" + contractId + " Not Present To Delete");
		} else {
			manager.remove(contractBean);
			transaction.commit();
			return true;
		}
	}

	@Override
	public List<ContractBean> getContract() {

		String jpql = "from ContractBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ContractBean> query = manager.createQuery(jpql, ContractBean.class);
		List<ContractBean> contractList = null;
		contractList = query.getResultList();
		if (contractList.isEmpty()) {
			throw new CustomerException("Sorry,Currently There is no Contractor details found");
		} else {
			return contractList;
		}
	}

	@Override
	public ContractBean viewContract(int contractId) throws NoResultException {
		String jpql = "from ContractBean where contractId=:contractId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ContractBean> query = manager.createQuery(jpql, ContractBean.class);

		ContractBean contractBean = null;
		query.setParameter("contractId", contractId);
		contractBean = query.getSingleResult();
		if (contractBean == null) {
			throw new CustomerException("Contract not found for  id:" + contractId + " To View");
		} else {
			return contractBean;
		}

	}

}
