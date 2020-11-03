package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ClientBean;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;

class ClientDAOImplTest {
	ClientDAOImpl obj=null;
	ClientBean client=null;
	
	@BeforeEach
	void load() {
		obj=new ClientDAOImpl();
	}
	@Test
	void testAddClient() {
		client=new ClientBean();
		client.setId(1);
		client.setClientUserName("ankita");
		client.setClientPassword("ankita");
		client.setRole("client");
		try {
			boolean flag=obj.addClient(client.getId(), client);
			assertEquals(flag, true);
		}catch(Exception e) {
			assertThrows(CustomerException.class, ()-> {
				obj.addClient(client.getId(), client);
			});
		}
	}
	
	@Test
	void testdeleteClient() {
		client=new ClientBean();
		client=new ClientBean();
		client.setId(1);
		client.setClientUserName("ankita");
		client.setClientPassword("ankita");
		client.setRole("client");
		try {
			boolean flag=obj.addClient(client.getId(), client);
			boolean flag2=obj.deleteClient(1);
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(CustomerException.class, ()-> {
				obj.addClient(client.getId(), client);
		});
	   }
		
	}
	

		
	}
	


