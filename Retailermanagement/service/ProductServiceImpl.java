package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao.ProductDao;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductBean;
@Service
public class ProductServiceImpl  implements ProductService{
@Autowired
   private ProductDao dao;
	@Override
	public boolean addProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.addProduct(bean);
	}

	@Override
	public ProductBean getProduct(int productid) {
		// TODO Auto-generated method stub
		return dao.getProduct(productid);
	}

	@Override
	public List<ProductBean> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

}
