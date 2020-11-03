package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.HauilerException;
public class HauilerDAOImpl implements HauilerDAO {
	static HashMap<Integer, HauilerBean> h1 = new HashMap<Integer, HauilerBean>();

	@Override
	public boolean addHauiler(HauilerBean bean, int hauilerid) throws HauilerException {

		HauilerBean hauilerBean = searchHauiler(hauilerid);
		if (hauilerBean != null) {
			throw new HauilerException("Hauiler Id: "+hauilerid+ " Already Present,Please Enter a differnt Id");
		} else {
			h1.put(hauilerid, bean);
		}

		if (h1.containsKey(hauilerid)) {
			return true;
		} else {
			throw new HauilerException("Hauiler ID :"+hauilerid+" Not Found To Add");
		}

	}

	@Override
	public boolean deleteHauiler(int hauilerid) throws HauilerException {

		HauilerBean hauilerBean = searchHauiler(hauilerid);

		if (hauilerBean != null) {
			h1.remove(hauilerid);
			return true;

		} else {
			throw new HauilerException("Hauiler ID :" + hauilerid + " Not Found To Delete");
		}
	}

	@Override
	public boolean modifyHauiler(int hauilerid, HauilerBean bean) throws HauilerException {

		HauilerBean hauilerBean = searchHauiler(hauilerid);

		if (hauilerBean != null) {
			h1.replace(hauilerid, bean);
			return true;

		} else {
			throw new HauilerException("Hauiler ID :" + hauilerid + " Not Found To Modify");
		}

	}

	@Override
	public HauilerBean searchHauiler(int hauilerid) throws HauilerException {
		if (h1.containsKey(hauilerid) == true) {
			return h1.get(hauilerid);
		} else {
			return null;
		}
	}

	@Override
	public void getHauiler() throws HauilerException {
		if (!h1.isEmpty()) {
			System.out.println(h1);
		} else {
			throw new HauilerException("Hauiler Details Are Not Present");
		}

	}

}
