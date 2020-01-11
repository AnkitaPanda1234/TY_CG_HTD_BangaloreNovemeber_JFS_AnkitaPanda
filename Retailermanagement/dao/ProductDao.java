package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao;

import java.util.List;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductBean;

public interface ProductDao {
	public boolean addProduct(ProductBean bean);
	public ProductBean getProduct(int productid);
	public List<ProductBean> getAllProduct();

}
