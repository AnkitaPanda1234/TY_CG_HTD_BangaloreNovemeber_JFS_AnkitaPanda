package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;

/**
 * 
 * @author Ankita Panda
 *
 */
public interface InventoryDAO {
	/**
	 * 
	 * @param prod
	 * @return
	 * @throws ProductException
	 */
	public boolean insertProduct(InventoryBean prod) throws ProductException;
	/**
	 * 
	 * @param productid
	 * @return
	 * @throws ProductException
	 */
	public boolean deleteProduct(int productid) throws ProductException;
	/**
	 * 
	 * @param productid
	 * @param productquanty
	 * @return
	 * @throws ProductException
	 */
	public boolean modifyProduct(int productid, String productDetails,String query) 
			throws ProductException;
	/**
	 * 
	 * @return
	 * @throws ProductException
	 */
	List<InventoryBean> getAllProduct() throws ProductException;
	/**
	 * 
	 * @param hauilerid
	 * @return
	 * @throws ProductException
	 */
	InventoryBean searchProduct(int productid) throws ProductException;

}
