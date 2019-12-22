package com.cap.moduletest1.dao;

import java.util.List;

import com.cap.moduletest1.baen.ProductBean;

public interface ProductDao {
	public List<ProductBean>showAllItems();
	public boolean buyProduct(ProductBean bean);
	public ProductBean searchItems(String productname);
	

}
