package com.cap.moduletest1.factory;

import com.cap.moduletest1.dao.ProductDao;
import com.cap.moduletest1.dao.ProductDaoImpl;

public class ProductFactory {
	
	
	public static ProductDao instanceOfProductDaoImpl()
	{
		ProductDao dao=new ProductDaoImpl();
		return dao;
	}
	
	

}
