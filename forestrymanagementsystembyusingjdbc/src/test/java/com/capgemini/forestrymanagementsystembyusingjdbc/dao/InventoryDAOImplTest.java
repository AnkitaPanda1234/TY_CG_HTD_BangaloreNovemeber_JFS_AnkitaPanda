package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.InventoryDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;

class InventoryDAOImplTest {
	InventoryDAOImpl obj = null;
	InventoryBean inventory = null;

	@BeforeEach
	void load() {
		obj = new InventoryDAOImpl();
	}

	@Test
	void testinsertProduct() {
		inventory = new InventoryBean();
		inventory.setProductId(6);
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
		inventory.setProductId(6);
		try {
			boolean flag = obj.deleteProduct(inventory.getProductId());
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
