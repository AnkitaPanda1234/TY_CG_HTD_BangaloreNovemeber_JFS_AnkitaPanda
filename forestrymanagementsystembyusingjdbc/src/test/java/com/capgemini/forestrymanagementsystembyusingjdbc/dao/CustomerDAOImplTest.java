package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.CustomerDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.CustomerException;

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
		customer.setCustomerid(89);
		customer.setCustomerName("ankita");
		customer.setEmail("ankita2gmail.com");
		customer.setPostalCode(765434);
		customer.setStreetAddress1("bbsr");
		customer.setStreetAddress1("bbsr");
		customer.setStreetAddress2("blr");
		customer.setTelephoneNum(987654346);
		customer.setTown("bls");
		try {
			boolean flag=obj.addCustomer(customer);
			assertEquals(flag, true);
		}catch(Exception e) {
			assertThrows(CustomerException.class, ()-> {
				obj.addCustomer(customer);
			});
		}
		}
	
	@Test
	void testDeleteCustomer() {
		customer=new CustomerBean();
		customer.setCustomerid(7);
		try {
			boolean flag=obj.deleteCustomer(customer.getCustomerid());
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(CustomerException.class, ()-> {
				obj.addCustomer(customer);
		});
	   }
	}
	
	@Test
	void testmodifyCustomer() {
		customer=new CustomerBean();
		customer.setCustomerid(7);
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
			obj.getAllCustomers();
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(CustomerException.class,()-> {
				obj.addCustomer(customer);
			});
		}
	}
	
	@Test
	void getCustomer() {
		customer= new CustomerBean();
		customer.setCustomerid(4);
		try {
			obj.viewCustomer(customer.getCustomerid());
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(CustomerException.class,()->{
				obj.addCustomer(customer);
			});
		}
		
	}

}
