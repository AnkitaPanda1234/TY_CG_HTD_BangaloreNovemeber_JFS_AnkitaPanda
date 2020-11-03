package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ProductBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ProductException;

class InventoryDAOImplTest {
	ProductDAOImpl obj = null;
	ProductBean inventory = null;

	@BeforeEach
	void load() {
		obj = new ProductDAOImpl();
	}

	@Test
	void testinsertProduct() {
		inventory = new ProductBean();
		inventory.setProductId(6);
		inventory.setProductName("tree");
		inventory.setProductQuantity(687);
		try {
			boolean flag = obj.addProduct(inventory, inventory.getProductId());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ProductException.class, () -> {
				obj.addProduct(inventory, inventory.getProductId());
			});
		}
	}

	@Test
	void testDeleteProduct() {
		inventory = new ProductBean();
		inventory.setProductId(6);
		try {
			boolean flag = obj.deleteProduct(inventory.getProductId());
			assertEquals(flag, true);

		} catch (Exception e) {
			assertThrows(ProductException.class, () -> {
				obj.addProduct(inventory, inventory.getProductId());
			});
		}
	}

	 @Test
	 void testmodifyProuct() {
		   inventory = new ProductBean();
			inventory.setProductId(6);
			inventory.setProductName("wood");
			inventory.setProductQuantity(687);
			try {
				boolean flag = obj.modifyproduct(inventory.getProductId(), inventory);
				assertEquals(flag, true);
			} catch (Exception e) {
				assertThrows(ProductException.class, () -> {
					obj.addProduct(inventory, inventory.getProductId());
				});
			}
	 
	 }

	

	@Test
	void testgetProduct() {
		inventory = new ProductBean();
		inventory.setProductId(2);
		try {
			obj.searchProduct(inventory.getProductId());
			assertEquals(obj, obj);
		} catch (Exception e) {
			assertThrows(ProductException.class, () -> {
				obj.addProduct(inventory, inventory.getProductId());
			});
		}
	}
}
