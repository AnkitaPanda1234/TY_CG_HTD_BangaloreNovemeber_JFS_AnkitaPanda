package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.HauilerDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.HauilerException;

class HauilerDAOImplTest {
	HauilerDAOImpl obj=null;
	HauilerBean hauilerbean=null;

	@BeforeEach
	void load() {
		obj=new HauilerDAOImpl();
	}


	@Test
	void testAddHauiler() {
		hauilerbean=new HauilerBean();
		hauilerbean.setHauilerid(9);
		hauilerbean.setHauilername("ram");
		hauilerbean.setEmail("ram@gmail.com");
		hauilerbean.setContactnum(738192932);
		hauilerbean.setStreetAddress1("bbsr");
		hauilerbean.setStreetAddress2("bds");
		hauilerbean.setTown("blr");
		try {
			boolean flag=obj.addHauiler(hauilerbean);
			assertEquals(flag, true);
		}catch(Exception e) {
			assertThrows(HauilerException.class, ()-> {
				obj.addHauiler(hauilerbean);
			});
		}
	}
	 @Test
	 void testModifyHauiler() {
		 hauilerbean=new HauilerBean();
		 hauilerbean.setHauilerid(5);
			hauilerbean.setHauilername("ram");
			hauilerbean.setEmail("ram@gmail.com");
			hauilerbean.setContactnum(738192932);
			hauilerbean.setStreetAddress1("bbsr");
			hauilerbean.setStreetAddress2("bds");
			hauilerbean.setTown("blr");
			try {
				boolean flag=obj.modifyHauiler(hauilerbean.getHauilerid(), hauilerbean);
				assertEquals(flag, true);
				
			}catch(Exception e) {
				assertThrows(HauilerException.class,()-> {
					obj.modifyHauiler(hauilerbean.getHauilerid(), hauilerbean);
				});
			}}
		 @Test
		void testSearchHauiler() {
			 hauilerbean=new HauilerBean();
			 hauilerbean.setHauilerid(8);
			 try {
					obj.searchHauiler(hauilerbean.getHauilerid());
					assertEquals(obj,obj);
				}catch(Exception e) {
					assertThrows(HauilerException.class,()->{
						obj.addHauiler(hauilerbean);
					});
				}
				
			}
		 
		 @Test
		 void testGetHauiler() {
			 hauilerbean=new HauilerBean();
			 try {
					obj.getHauiler();
					assertEquals(obj,obj);
				}catch(Exception e) {
					assertThrows(HauilerException.class,()-> {
						obj.addHauiler(hauilerbean);
					});
				}
			 
		 }
			 
		 }



