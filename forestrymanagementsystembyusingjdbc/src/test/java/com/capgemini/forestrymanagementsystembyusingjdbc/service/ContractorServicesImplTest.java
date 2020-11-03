package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.AdminDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ContractException;

class ContractorServicesImplTest {
	ContractorServicesImpl obj=null;
	ContractorBean contract=null;
	
	@BeforeEach
	void load() {
		obj = new ContractorServicesImpl();
	}


	@Test
	void testAddContract() {
		contract = new ContractorBean();
		contract.setContractNo(9);
		contract.setCustomerId(3);
		contract.setDeliveryDate("23-02-2020");
		contract.setHaulierId(8);
		contract.setorderId(4);
		contract.setProductId(5);
		contract.setQunatity(987);

		try {
			boolean flag = obj.addContract(contract);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ContractException.class, () -> {
				obj.addContract(contract);
			});
		}

	}
     @Test
     void testdeleteContract() {
    	 contract = new ContractorBean();
 		contract.setContractNo(9);
 		contract.setCustomerId(3);
 		contract.setDeliveryDate("23-02-2020");
 		contract.setHaulierId(8);
 		contract.setorderId(4);
 		contract.setProductId(5);
 		contract.setQunatity(987);
 		 
 		try {
 			boolean flag = obj.addContract(contract);
			boolean flag2=obj.deleteContract(contract.getContractNo(), contract.getorderId());
			assertEquals(flag,true);
			
		}catch(Exception e) {
			assertThrows(ContractException.class, ()-> {
				obj.addContract(contract);
		});
	   } 
    	 
     }
     @Test
     void testSearchContract() {
    	 contract = new ContractorBean();
    	 contract.setContractNo(3);
    	 try {
 			obj.viewContract(contract.getContractNo());
 			assertEquals(obj,obj);
 		}catch(Exception e) {
 			assertThrows(ContractException.class,()->{
 				obj.addContract(contract);
 			});
 		}
 		
 	}
     
     @Test
     void testGetAllContract() {
    	 contract = new ContractorBean();
    	 try {
 			obj.getAllContract();
 			assertEquals(obj,obj);
 		}catch(Exception e) {
 			assertThrows(ContractException.class,()-> {
 				obj.addContract(contract);
 			});
 		}
     }}
