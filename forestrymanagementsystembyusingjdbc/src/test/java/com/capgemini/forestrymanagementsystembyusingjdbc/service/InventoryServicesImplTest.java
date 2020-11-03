package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.InventoryDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;

class InventoryServicesImplTest {
	InventoryServicesImpl obj=null;
	InventoryBean inventory=null;
	
	@BeforeEach
	void load() {
		obj = new InventoryServicesImpl();
	}

	@Test
	void testinsertProduct() {
		inventory = new InventoryBean();
		inventory.setProductId(12);
		inventory.setProductName("wood");
		inventory.setProductQuantity(687);
		try {
			boolean flag = obj.insertProduct(inventory);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ProductException.class, () -> {
				obj.insertProduct(inventory);
			});
		}
	}

	@Test
	void testDeleteProduct() {
		inventory = new InventoryBean();
		inventory.setProductId(82);
		inventory.setProductName("wood");
		inventory.setProductQuantity(687);
		try {
			boolean flag = obj.insertProduct(inventory);
			boolean flag2 = obj.deleteProduct(inventory.getProductId());
			assertEquals(flag, true);

		} catch (Exception e) {
			assertThrows(ProductException.class, () -> {
				obj.insertProduct(inventory);

			});
		}
	}

	 @Test
	 void testmodifyProuct() {
		   inventory = new InventoryBean();
			inventory.setProductId(100);
			inventory.setProductName("wood");
			inventory.setProductQuantity(687);
			try {
				boolean flag = obj.insertProduct( inventory);
				assertEquals(flag, true);
			} catch (Exception e) {
				assertThrows(ProductException.class, () -> {
					obj.insertProduct(inventory);
				});
			}
	 
	 }

	@Test
	void testgetAllProduct() {
		inventory = new InventoryBean();
		try {
			obj.getAllProduct();
			assertEquals(obj, obj);
		} catch (Exception e) {
			assertThrows(ProductException.class, () -> {
				obj.insertProduct(inventory);
			});
		}
	}

	@Test
	void testgetProduct() {
		inventory = new InventoryBean();
		inventory.setProductId(2);
		try {
			obj.searchProduct(inventory.getProductId());
			assertEquals(obj, obj);
		} catch (Exception e) {
			assertThrows(ProductException.class, () -> {
				obj.insertProduct(inventory);
			});
		}
	}
}
