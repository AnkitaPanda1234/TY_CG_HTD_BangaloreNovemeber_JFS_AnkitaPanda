package com.capgemini.forestrymanagementsystemspringrest.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dao.InventoryDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class InventoryServiceTest {

	@Autowired
	InventoryService inventoryService;

	@Test
	void testAddInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryService.addInventory(inventoryBean));
	}

	@Test
	void testDeleteInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryService.addInventory(inventoryBean));
		assertTrue(inventoryService.deleteInventory(inventoryBean.getProductid()));
	}

	@Test
	void testGetAllInventory() {
		assertNotNull(inventoryService.getAllInventory());
	}

	@Test
	void testModifyInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryService.addInventory(inventoryBean));
		assertTrue(inventoryService.modifyInventory(inventoryBean.getProductid(), inventoryBean));
		assertTrue(inventoryService.deleteInventory(inventoryBean.getProductid()));
	}

	@Test
	void testGetInventory() {
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setProductname("PINKI");
		inventoryBean.setProductquantity(100);
		assertTrue(inventoryService.addInventory(inventoryBean));
		assertNotNull(inventoryService.getInventory(inventoryBean.getProductid()));
	}
}
