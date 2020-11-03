package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;

public interface InventoryService {
	public boolean addInventory(InventoryBean bean);

	public boolean deleteInventory(int productid);

	public List<InventoryBean> getAllInventory();

	public boolean modifyInventory(int productid, InventoryBean bean);

	public InventoryBean getInventory(int productid);

}
