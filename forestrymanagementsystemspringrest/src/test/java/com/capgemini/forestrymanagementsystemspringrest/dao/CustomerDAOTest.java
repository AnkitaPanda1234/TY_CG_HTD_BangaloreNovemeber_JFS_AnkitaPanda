package com.capgemini.forestrymanagementsystemspringrest.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class CustomerDAOTest {
	@Autowired
	CustomerDAO customerDao;

	@Test
	void testGetAllCustomer() {
		assertNotNull(customerDao.getAllCustomer());
	}

	@Test
	void testAddCustomer() {
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustomerName("ankita");
		customerBean.setEmail("ankita2gmail.com");
		customerBean.setPostalCode(765434);
		customerBean.setStreetAddress1("bbsr");
		customerBean.setTelephoneNum(987654345);
		customerBean.setTown("blr");
		assertTrue(customerDao.addCustomer(customerBean));
		customerDao.deleteCustomer(customerBean.getCustomerid());

	}

	@Test
	void testModifyCustomer() {
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustomerName("ankita");
		customerBean.setEmail("ankita2gmail.com");
		customerBean.setPostalCode(765434);
		customerBean.setStreetAddress1("bbsr");
		customerBean.setTelephoneNum(987654345);
		customerBean.setTown("blr");
		assertTrue(customerDao.addCustomer(customerBean));
		assertTrue(customerDao.modifyCustomer(customerBean.getCustomerid(), customerBean));
		customerDao.deleteCustomer(customerBean.getCustomerid());
	}

	@Test
	void testDeleteCustomer() {
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustomerName("ankita");
		customerBean.setEmail("ankita2gmail.com");
		customerBean.setPostalCode(765434);
		customerBean.setStreetAddress1("bbsr");
		customerBean.setTelephoneNum(987654345);
		customerBean.setTown("blr");
		assertTrue(customerDao.addCustomer(customerBean));
		assertTrue(customerDao.deleteCustomer(customerBean.getCustomerid()));
	}

	@Test
	void testSearchCustomer() {
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustomerName("ankita");
		customerBean.setEmail("ankita2gmail.com");
		customerBean.setPostalCode(765434);
		customerBean.setStreetAddress1("bbsr");
		customerBean.setTelephoneNum(987654345);
		customerBean.setTown("blr");
		assertTrue(customerDao.addCustomer(customerBean));
		assertNotNull(customerDao.getCustomer(customerBean.getCustomerid()));

	}

}
