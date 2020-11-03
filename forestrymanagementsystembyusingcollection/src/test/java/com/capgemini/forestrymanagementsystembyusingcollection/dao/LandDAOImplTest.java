package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.LandBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LandException;

class LandDAOImplTest {
	LandDAOImpl obj = null;
	LandBean land = null;

	@BeforeEach
	void load() {
		obj = new LandDAOImpl();
	}

	@Test
	void testAddLandDetails() {
		land = new LandBean();
		land.setLandid(5);
		land.setLandlocation("bbsr");
		land.setLandvalue(767);
		land.setRelesedate("29-03-2020");
		try {
			boolean flag = obj.addDetails(land, land.getLandid());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.addDetails(land, land.getLandid());
			});
		}

	}

	

	@Test
	void testUpdateLandDeatails() {
		land = new LandBean();
		land.setLandid(5);
		land.setLandvalue(65);

		try {
			boolean flag = obj.updateLand(land.getLandid(),land);
			assertEquals(flag, true);

		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.updateLand(land.getLandid(),land);
			});
		}
	}

	
	@Test
	void testViewLandDetails() {
		land = new LandBean();
		land.setLandid(5);
		try {
			obj.getLand(land.getLandid());
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(LandException.class,()->{
				obj.addDetails(land, land.getLandid());
			});
		}
		
	}
	
	}

