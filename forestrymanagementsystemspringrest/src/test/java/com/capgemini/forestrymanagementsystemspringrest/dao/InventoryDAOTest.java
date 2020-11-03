package com.capgemini.forestrymanagementsystemspringrest.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class InventoryDAOTest {

	@Autowired
	InventoryDAO inventoryDAO;

	@Test
	void testAddInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryDAO.addInventory(inventoryBean));
		assertTrue(inventoryDAO.deleteInventory(inventoryBean.getProductid()));
	}

	@Test
	void testDeleteInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryDAO.addInventory(inventoryBean));
		assertTrue(inventoryDAO.deleteInventory(inventoryBean.getProductid()));
	}

	@Test
	void testGetAllInventory() {
		assertNotNull(inventoryDAO.getAllInventory());
	}

	@Test
	void testModifyInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryDAO.addInventory(inventoryBean));
		assertTrue(inventoryDAO.modifyInventory(inventoryBean.getProductid(), inventoryBean));
	}

	@Test
	void testGetInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryDAO.addInventory(inventoryBean));
		assertNotNull(inventoryDAO.getInventory(inventoryBean.getProductid()));
	}
}
