package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao;

import java.util.List;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderBean;

public interface OrderDao {
	
	public boolean addOrder(OrderBean order);
	public OrderBean getOrder(int orderid);
	public List<OrderBean> getAllOrder();

}
