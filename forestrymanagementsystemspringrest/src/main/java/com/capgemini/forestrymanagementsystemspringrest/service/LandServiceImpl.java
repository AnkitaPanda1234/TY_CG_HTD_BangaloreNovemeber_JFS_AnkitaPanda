package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspringrest.dao.LandDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.util.Validation;

@Service
public class LandServiceImpl implements LandService {
	@Autowired
	private LandDAO dao;

	@SuppressWarnings("static-access")
	@Override
	public boolean addLandDetails(LandBean land) {
		Validation v = new Validation();
		String landlocation = land.getLandLocation();
		if (v.addresValidation(landlocation)) {
			land.setLandLocation(landlocation);
		} else {
			throw new CustomerException("Please Enter Proper Location in location field");
		}
//		String date = land.getRealisedDate();
//		if (v.isValidDate(date)) {
//			land.setRealisedDate(date);
//		} else {
//			throw new CustomerException("Please Enter Currect date that shouldbe in \"yyyy-MM-dd\" in formate ");
//		}
		return dao.addLandDetails(land);
	}

	@Override
	public boolean deleteLandDetails(int landid) {

		return dao.deleteLandDetails(landid);
	}

	@Override
	public boolean updateLandDeatails(int landid, long landvalue) {
		return dao.updateLandDeatails(landid, landvalue);
	}

	@Override
	public List<LandBean> showLandDetails() {
		return dao.showLandDetails();
	}

	@Override
	public LandBean viewLandDetails(int landid) {
		return dao.viewLandDetails(landid);
	}

}
