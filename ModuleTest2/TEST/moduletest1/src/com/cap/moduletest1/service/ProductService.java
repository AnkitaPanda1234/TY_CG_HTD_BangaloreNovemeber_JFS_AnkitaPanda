package com.cap.moduletest1.service;

import java.util.List;

import com.cap.moduletest1.baen.ProductBean;

public interface ProductService {
	public List<ProductBean>showAllItems();
	public boolean buyProduct(ProductBean bean);
	public ProductBean searchItems(String productname);

}
