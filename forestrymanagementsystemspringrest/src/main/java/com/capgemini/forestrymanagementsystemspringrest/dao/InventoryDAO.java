package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;

public interface InventoryDAO {
	public boolean addInventory(InventoryBean bean);

	public boolean deleteInventory(int productid);

	public List<InventoryBean> getAllInventory();

	public boolean modifyInventory(int productid, InventoryBean bean);

	public InventoryBean getInventory(int productid);

}
