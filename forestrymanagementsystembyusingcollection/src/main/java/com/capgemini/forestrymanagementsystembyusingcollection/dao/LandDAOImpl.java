package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.LandBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LandException;
public class LandDAOImpl implements LandDAO {
	static HashMap<Integer, LandBean> h1 = new HashMap<Integer, LandBean>();

	@Override
	public boolean addDetails(LandBean bean, int landid) throws LandException {

		LandBean lndBean = getLand(landid);
		if (lndBean != null) {
			throw new LandException("Land Id " + landid + " Already Present,Please Enter another Id");
		} else {
			h1.put(landid, bean);
		}

		if (h1.containsKey(landid)) {
			return true;
		} else {
			throw new LandException("Land Id " + landid + " Already Present,Please Enter another Id");
		}

	}

	@Override
	public boolean deleteLand(int landid) throws LandException {

		LandBean lndBean = getLand(landid);
		if (lndBean != null) {
			h1.remove(landid);
			return true;

		} else {
			throw new LandException(" Land ID :" + landid + " Not Found To Delete A Record");
		}

	}

	@Override
	public void getAllLandDetails() throws LandException {
		if (!h1.isEmpty()) {
			System.out.println(h1);
		} else {
			throw new LandException("Land Details Are Not Present");
		}

	}

	@Override
	public boolean updateLand(int landid, LandBean bean) throws LandException {

		LandBean lndBean = getLand(landid);
		if (lndBean != null) {
			h1.replace(landid, bean);
			return true;

		} else {
			throw new LandException(" Land ID :" + landid + " Not Found To Modify");
		}

	}

	@Override
	public LandBean getLand(int landid) throws LandException {
		if (h1.containsKey(landid)) {
			return h1.get(landid);
		} else {
			return null;
		}
	}
}
