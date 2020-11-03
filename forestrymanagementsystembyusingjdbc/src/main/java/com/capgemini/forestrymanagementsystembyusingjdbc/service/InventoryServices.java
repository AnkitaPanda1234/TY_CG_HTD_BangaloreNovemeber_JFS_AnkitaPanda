package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;

/**
 * 
 * @author Ankita Panda
 *
 */
public interface InventoryServices {
	public boolean insertProduct(InventoryBean prod) throws ProductException;

	public boolean deleteProduct(int productid) throws ProductException;

	public boolean modifyProduct(int productid, String proudctDetail,String query) throws ProductException;

	public List<InventoryBean> getAllProduct() throws ProductException;

	InventoryBean searchProduct(int productid) throws ProductException;

}
