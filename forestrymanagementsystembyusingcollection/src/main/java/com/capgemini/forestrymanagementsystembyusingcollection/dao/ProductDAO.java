package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ProductBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ProductException;

public interface ProductDAO {

	boolean addProduct(ProductBean bean, int productid) throws ProductException;

	boolean deleteProduct(int productid) throws ProductException;

	ProductBean searchProduct(int productid) throws ProductException;

	boolean modifyproduct(int productid, ProductBean bean) throws ProductException;

	public void getAllProducts() throws ProductException;

}
