package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.HauilerException;
/**
 * 
 * @author Ankita Panda
 *
 */
public interface HauilerDAO {

	boolean addHauiler(HauilerBean bean)throws HauilerException;

	boolean deleteHauiler(int hauilerid)throws HauilerException;

	boolean modifyHauiler(int hauilerid, HauilerBean bean)throws HauilerException;

	HauilerBean searchHauiler(int hauilerid)throws HauilerException;

	public List<HauilerBean> getHauiler() throws HauilerException;

}
