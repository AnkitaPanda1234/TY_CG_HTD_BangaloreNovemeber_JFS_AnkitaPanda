package com.capgemini.forestrymanagementsystemspringrest.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dto.ContractBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class ContractDAOTest {

	@Autowired
	ContractDAO contractDao;

	@Test
	void testAddContractor() {
		ContractBean contractBean = new ContractBean();
		contractBean.setCustomerId(40);
		contractBean.setProductId(11);
		contractBean.setQunatity(2);
		contractBean.setOrderId(1);
		contractBean.setStatus("Ordered");
		contractBean.setDeliveryDate("26-01-2020");
		assertTrue(contractDao.addContract(contractBean));
		assertTrue(contractDao.deleteContract(contractBean.getContractId()));
	}

	@Test
	void testviewContract() {
		ContractBean contractBean = new ContractBean();
		contractBean.setCustomerId(40);
		contractBean.setProductId(11);
		contractBean.setQunatity(2);
		contractBean.setOrderId(1);
		contractBean.setStatus("Ordered");
		contractBean.setDeliveryDate("26-01-2020");
		assertTrue(contractDao.addContract(contractBean));
		assertNotNull(contractDao.viewContract(contractBean.getContractId()));
	}

	@Test
	void testgetContract() {
		assertNotNull(contractDao.getContract());
	}

	@Test
	void testdeleteContract() {
		ContractBean contractBean = new ContractBean();
		contractBean.setCustomerId(40);
		contractBean.setProductId(11);
		contractBean.setQunatity(2);
		contractBean.setOrderId(1);
		contractBean.setStatus("Ordered");
		contractBean.setDeliveryDate("26-01-2020");
		assertTrue(contractDao.addContract(contractBean));
		
		assertTrue(contractDao.deleteContract(contractBean.getContractId()));
	}

}
