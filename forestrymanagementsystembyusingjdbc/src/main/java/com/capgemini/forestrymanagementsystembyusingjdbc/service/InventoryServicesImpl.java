package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.InventoryDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;

public class InventoryServicesImpl implements InventoryServices {
	InventoryDAO dao=Factory.instanceOfInventoryDAOImpl();

	@Override
	public boolean insertProduct(InventoryBean prod) throws ProductException {
		return dao.insertProduct(prod);
	}

	@Override
	public boolean deleteProduct(int productid) throws ProductException {
		return dao.deleteProduct(productid);
	}

	@Override
	public boolean modifyProduct(int productid, String productquanty,String query) throws ProductException {
		return dao.modifyProduct(productid, productquanty,query);
	}

	@Override
	public List<InventoryBean> getAllProduct()  throws ProductException{
		return dao.getAllProduct();
	}

	@Override
	public InventoryBean searchProduct(int productid) throws ProductException {
		return dao.searchProduct(productid);
	}

	
	

}
