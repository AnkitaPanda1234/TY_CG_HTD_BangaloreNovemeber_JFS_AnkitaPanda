package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service;

import java.util.List;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean bean);
	public ProductBean getProduct(int productid);
	public List<ProductBean> getAllProduct();


}
