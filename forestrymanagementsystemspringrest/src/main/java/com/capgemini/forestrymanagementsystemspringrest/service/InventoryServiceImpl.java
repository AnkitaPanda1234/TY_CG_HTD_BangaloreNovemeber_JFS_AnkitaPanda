package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspringrest.dao.InventoryDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.exception.InventoryException;
import com.capgemini.forestrymanagementsystemspringrest.util.Validation;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryDAO dao;

	@Override
	public boolean addInventory(InventoryBean bean) {
		Validation v = new Validation();
		String productname = bean.getProductname();
		if (v.nameValidation(productname)) {
			bean.setProductname(productname);
		} else {
			throw new CustomerException("Product Name should contain only letters");
		}
		return dao.addInventory(bean);
	}

	@Override
	public boolean deleteInventory(int productid) {

		return dao.deleteInventory(productid);
	}

	@Override
	public List<InventoryBean> getAllInventory() {

		return dao.getAllInventory();
	}

	@Override
	public boolean modifyInventory(int productid, InventoryBean bean) {

		Validation v = new Validation();
		String productname = bean.getProductname();
		if (v.nameValidation(productname)) {
			bean.setProductname(productname);
		} else {
			throw new CustomerException("Product Name should contain only letters");
		}

		return dao.modifyInventory(productid, bean);
	}

	@Override
	public InventoryBean getInventory(int productid) {
		// if(dao!=null) {
		// System.out.println("InventoryBean Is Not Null");
		// }else {
		// System.out.println("InventoryBean Null");
		// }
		return dao.getInventory(productid);
	}
}
