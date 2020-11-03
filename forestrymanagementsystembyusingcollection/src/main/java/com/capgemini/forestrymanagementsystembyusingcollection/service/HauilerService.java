package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.HauilerException;

public interface HauilerService {
	
	boolean addHauiler(HauilerBean bean, int hauilerid)throws HauilerException;

	boolean deleteHauiler(int hauilerid)throws HauilerException;

	boolean modifyHauiler(int hauilerid, HauilerBean bean)throws HauilerException;

	HauilerBean searchHauiler(int hauilerid)throws HauilerException;

	public void getHauiler() throws HauilerException;

}
