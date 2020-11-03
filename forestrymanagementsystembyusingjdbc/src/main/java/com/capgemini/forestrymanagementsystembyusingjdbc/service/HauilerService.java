package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.HauilerException;
/**
 * 
 * @author Ankita Panda
 *
 */
public interface HauilerService {

	boolean addHauiler(HauilerBean bean)throws HauilerException;

	boolean deleteHauiler(int hauilerId)throws HauilerException;

	boolean modifyHauiler(int hauilerId, HauilerBean bean)throws HauilerException;

	HauilerBean searchHauiler(int hauilerId)throws HauilerException;

	public List<HauilerBean> getHauiler() throws HauilerException;
}
