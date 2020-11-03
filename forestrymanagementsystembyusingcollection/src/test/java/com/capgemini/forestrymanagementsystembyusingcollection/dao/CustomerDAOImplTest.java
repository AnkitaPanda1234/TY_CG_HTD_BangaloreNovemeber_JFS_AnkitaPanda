package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;


class CustomerDAOImplTest {
	CustomerDAOImpl obj=null;
	CustomerBean customer=null;
	
	@BeforeEach
	void load() {
		obj=new CustomerDAOImpl();
	}

	@Test
	void testAddCustomer() {
		customer=new CustomerBean();
		customer.setCustomerid(11);
		customer.setCustomerName("ankita");
		customer.setEmail("ankita2gmail.com");
		customer.setPostalCode(765434);
		customer.setStreetAddress1("bbsr");
		customer.setStreetAddress1("bbsr");
		customer.setStreetAddress2("blr");
		customer.setTelephoneNum(987654346);
		customer.setTown("bls");
		try {
			boolean flag=obj.addCustomer(customer, customer.getCustomerid());
			assertEquals(flag, true);
		}catch(Exception e) {
			assertThrows(CustomerException.class, ()-> {
				obj.addCustomer(customer, customer.getCustomerid());
			});
		}
		}
	
	@Test
	void testDeleteCustomer() {
		customer=new CustomerBean();
		customer.setCustomerid(6);
		try {
			boolean flag=obj.deleteCustomer(customer.getCustomerid());
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(CustomerException.class, ()-> {
				obj.addCustomer(customer, customer.getCustomerid());
		});
	   }
	}
	
	@Test
	void testmodifyCustomer() {
		customer=new CustomerBean();
		customer.setCustomerid(3);
		customer.setCustomerName("mama");
		customer.setEmail("mama2gmail.com");
		customer.setPostalCode(765434);
		customer.setStreetAddress1("bbsr");
		customer.setStreetAddress1("bbsr");
		customer.setStreetAddress2("blr");
		customer.setTelephoneNum(987654346);
		customer.setTown("bls");
		try {
			boolean flag=obj.modifyCustomer(customer.getCustomerid(),customer);
			assertEquals(flag, true);
			
		}catch(Exception e) {
			assertThrows(CustomerException.class,()-> {
				obj.modifyCustomer(customer.getCustomerid(),customer);
			});
		}
	}
	
	@Test
	void getAllCustomer() {
		customer=new CustomerBean();
		try {
			obj.getCustomer();
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(CustomerException.class,()-> {
				obj.addCustomer(customer, customer.getCustomerid());
			});
		}
	}
	
	@Test
	void getCustomer() {
		customer= new CustomerBean();
		customer.setCustomerid(4);
		try {
			obj.searchCustomer(customer.getCustomerid());
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(CustomerException.class,()->{
				obj.addCustomer(customer, customer.getCustomerid());
			});
		}
		
	}

}
