package com.capgemini.forestrymanagementsystemspringrest.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class LandDAOTest {

	@Autowired
	LandDAO landDao;

	@Test
	void testAddLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("26-01-2020");
		assertTrue(landDao.addLandDetails(landBean));
		assertTrue(landDao.deleteLandDetails(landBean.getLandid()));
	}

	@Test
	void testviewLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("26-01-2020");
		assertTrue(landDao.addLandDetails(landBean));
		assertNotNull(landDao.viewLandDetails(landBean.getLandid()));
		assertTrue(landDao.deleteLandDetails(landBean.getLandid()));
	}

	@Test
	void testgetAllLand() {
		assertNotNull(landDao.showLandDetails());
	}

	@Test
	void testUpdateLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("26-01-2020");
		assertTrue(landDao.addLandDetails(landBean));
		assertTrue(landDao.updateLandDeatails(landBean.getLandid(), landBean.getLandValue()));
		assertTrue(landDao.deleteLandDetails(landBean.getLandid()));
	}

	@Test
	void testDeleteLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("26-01-2020");
		assertTrue(landDao.addLandDetails(landBean));
		assertTrue(landDao.deleteLandDetails(landBean.getLandid()));

	}

}
