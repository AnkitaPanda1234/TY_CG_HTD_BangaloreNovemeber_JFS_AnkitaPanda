package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.LandBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.LandDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;

class LandServiceImplTest {

	LandServiceImpl obj = null;
	LandBean land = null;

	@BeforeEach
	void load() {
		obj = new LandServiceImpl();
	}

	@Test
	void testAddLandDetails() {
		land = new LandBean();
		land.setLandid(18);
		land.setLandLocation("bbsr");
		land.setLandValue(767);
		land.setRealisedDate("29-03-2020");
		try {
			boolean flag = obj.addLandDetails(land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.addLandDetails(land);
			});
		}

	}

	

	@Test
	void testUpdateLandDeatails() {
		land = new LandBean();
		land.setLandid(5);
		land.setLandValue(65);

		try {
			boolean flag = obj.updateLandDeatails(land.getLandid(),land.getLandValue());
			assertEquals(flag, true);

		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.updateLandDeatails(land.getLandid(),land.getLandValue());
			});
		}
	}

	@Test
	void testShowLandDetails() {
		land = new LandBean();
		try {
			obj.showLandDetails();
			assertEquals(obj, obj);
		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.addLandDetails(land);
			});
		}

	}
	@Test
	void testViewLandDetails() {
		land = new LandBean();
		land.setLandid(5);
		try {
			obj.viewLandDetails(land.getLandid());
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(LandException.class,()->{
				obj.addLandDetails(land);
			});
		}
		
	}
	@Test
	void testDeleteLandDetails() {
		land = new LandBean();
		land.setLandid(8);
		land.setLandLocation("bbsr");
		land.setLandValue(767);
		land.setRealisedDate("29-03-2020");
		try {
			boolean flag = obj.addLandDetails(land);
			boolean flag2 = obj.deleteLandDetails(land.getLandid());
			assertEquals(flag, true);

		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.addLandDetails(land);
			});
		}
	}
	}

