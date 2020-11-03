package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ProductBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ProductException;
public class ProductDAOImpl implements ProductDAO {

	static HashMap<Integer, ProductBean> h3 = new HashMap<Integer, ProductBean>();

	@Override
	public boolean addProduct(ProductBean bean, int productId) throws ProductException {

		ProductBean productBean = searchProduct(productId);
		if (productBean != null) {
			throw new ProductException("Product Id: " + productId + " Already Present,Please Enter a differnt Id");
		} else {
			h3.put(bean.getProductId(), bean);
		}

		if (h3.containsKey(productId)) {
			return true;
		} else {
			throw new ProductException("Product Id: " + productId + " Already Present,Please Enter a differnt Id");
		}
	}

	@Override
	public boolean deleteProduct(int productId) throws ProductException {

		ProductBean productBean = searchProduct(productId);
		if (productBean != null) {
			h3.remove(productId);
			return true;

		} else {
			throw new ProductException("Product ID :" + productId + " Not Found To Delete");
		}

	}

	@Override
	public boolean modifyproduct(int productId, ProductBean bean) throws ProductException {
		ProductBean productBean = searchProduct(productId);
		if (productBean != null) {
			h3.replace(productId, bean);
			return true;
		} else {
			throw new ProductException("Product ID :" + productId + " Not Found To Modify");
		}

	}

	@Override
	public void getAllProducts() throws ProductException {
		if (!h3.isEmpty()) {
			System.out.println(h3);
		} else {
			throw new ProductException("Product Deatils Are not Present");
		}
	}

	@Override
	public ProductBean searchProduct(int productId) throws ProductException {
		if (h3.containsKey(productId)) {
			return h3.get(productId);
		} else {
			return null;
		}
	}

}
