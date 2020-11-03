package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;
class ContractorDAOImplTest {
	ContractorDAOImpl obj = null;
	ContractorBean contract = null;

	@BeforeEach
	void load() {
		obj = new ContractorDAOImpl();
	}

	@Test
	void testAddContract() {
		contract = new ContractorBean();
		contract.setContractNo(9);
		contract.setCustomerId(3);
		contract.setDeliveryDate("23-02-2020");
		contract.setHaulierId(8);
		contract.setOrderId(4);
		contract.setProductId(5);
		contract.setQunatity(987);

		try {
			boolean flag = obj.addContarctor(contract, contract.getContractNo());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ContractException.class, () -> {
				obj.addContarctor(contract, contract.getContractNo());
			});
		}

	}
     
     
   
     @Test
     void testSearchContract() {
    	 contract = new ContractorBean();
    	 contract.setContractNo(2);
    	 try {
 			obj.searchContract(contract.getContractNo());
 			assertEquals(obj,obj);
 		}catch(Exception e) {
 			assertThrows(CustomerException.class,()->{
 				obj.addContarctor(contract, contract.getContractNo());
 			});
 		}
 		
 	}
     
     @Test
     void testGetAllContract() {
    	 contract = new ContractorBean();
    	 try {
 			obj.getAllContracts();
 			assertEquals(obj,obj);
 		}catch(Exception e) {
 			assertThrows(CustomerException.class,()-> {
 				obj.addContarctor(contract, contract.getContractNo());
 			});
 		}
     }}
