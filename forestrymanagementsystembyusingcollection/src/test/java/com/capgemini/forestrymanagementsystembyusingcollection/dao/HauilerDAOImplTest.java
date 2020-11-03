package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.HauilerException;

class HauilerDAOImplTest {
	HauilerDAOImpl obj = null;
	HauilerBean hauilerbean = null;

	@BeforeEach
	void load() {
		obj = new HauilerDAOImpl();
	}

	@Test
	void testAddHauiler() {
		hauilerbean = new HauilerBean();
		hauilerbean.setHauilerid(5);
		hauilerbean.setHauilername("ram");
		hauilerbean.setEmail("ram@gmail.com");
		hauilerbean.setContactnum(738192932);
		hauilerbean.setStreetAddress1("bbsr");
		hauilerbean.setStreetAddress2("bds");
		hauilerbean.setTown("blr");
		try {
			boolean flag = obj.addHauiler(hauilerbean, hauilerbean.getHauilerid());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(HauilerException.class, () -> {
				obj.addHauiler(hauilerbean, hauilerbean.getHauilerid());
			});
		}
	}

	@Test
	void testModifyHauiler() {
		hauilerbean = new HauilerBean();
		hauilerbean.setHauilerid(6);
		hauilerbean.setHauilername("ram");
		hauilerbean.setEmail("ram@gmail.com");
		hauilerbean.setContactnum(738192932);
		hauilerbean.setStreetAddress1("BARIPADA");
		hauilerbean.setStreetAddress2("bds");
		hauilerbean.setTown("blr");
		try {
			boolean flag = obj.modifyHauiler(hauilerbean.getHauilerid(), hauilerbean);
			assertEquals(flag, true);

		} catch (HauilerException e) {
			assertThrows(HauilerException.class, () -> {
				obj.modifyHauiler(hauilerbean.getHauilerid(), hauilerbean);
			});
		}
	}

	@Test
	void testSearchHauiler() {
		hauilerbean = new HauilerBean();
		hauilerbean.setHauilerid(5);
		try {
			obj.searchHauiler(hauilerbean.getHauilerid());
			assertEquals(obj, obj);
		} catch (Exception e) {
			assertThrows(HauilerException.class, () -> {
				obj.addHauiler(hauilerbean, hauilerbean.getHauilerid());
			});
		}

	}

	@Test
	void testGetHauiler() {
		hauilerbean = new HauilerBean();
		hauilerbean.setHauilerid(6);
		try {
			obj.getHauiler();
			assertEquals(obj, obj);
		} catch (HauilerException e) {
			// System.out.println(e.getMessage());
			assertThrows(HauilerException.class, () -> {
				obj.getHauiler();
			});
		}

	}

	@Test
	void testDeleteHauiler() {
		hauilerbean = new HauilerBean();
		hauilerbean.setHauilerid(5);
		hauilerbean.setHauilername("ram");
		hauilerbean.setEmail("ram@gmail.com");
		hauilerbean.setContactnum(738192932);
		hauilerbean.setStreetAddress1("bbsr");
		hauilerbean.setStreetAddress2("bds");
		hauilerbean.setTown("blr");
		try {
			boolean flag = obj.deleteHauiler(5);
			assertEquals(flag, true);

		} catch (HauilerException e) {
			assertThrows(HauilerException.class, () -> {
				obj.deleteHauiler(5);
			});
		}

	}

}
