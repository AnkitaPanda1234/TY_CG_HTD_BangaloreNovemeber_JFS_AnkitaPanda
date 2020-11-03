package com.capgemini.forestrymanagementsystemspringrest.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dao.LandDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class LandServiceTest {

	@Autowired
	LandService landService;

	@Test
	void testAddLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("29-01-2020");
		assertTrue(landService.addLandDetails(landBean));
	}

	@Test
	void testviewLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("29-01-2020");
		assertTrue(landService.addLandDetails(landBean));
		assertNotNull(landService.viewLandDetails(landBean.getLandid()));
	}

	@Test
	void testgetAllLand() {
		assertNotNull(landService.showLandDetails());
	}

	@Test
	void testUpdateLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("29-01-2020");
		assertTrue(landService.addLandDetails(landBean));
		assertTrue(landService.updateLandDeatails(landBean.getLandid(),landBean.getLandValue()));
	}

	@Test
	void testDeleteLand() {
		LandBean landBean = new LandBean();
		landBean.setLandLocation("Bangalore");
		landBean.setLandValue(12345);
		landBean.setRealisedDate("29-01-2020");
		assertTrue(landService.addLandDetails(landBean));
		assertTrue(landService.deleteLandDetails(landBean.getLandid()));

	}

}
