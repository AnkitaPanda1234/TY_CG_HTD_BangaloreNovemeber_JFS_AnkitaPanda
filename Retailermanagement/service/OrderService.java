package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service;

import java.util.List;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean order);
	public OrderBean getOrder(int orderid);
	public List<OrderBean> getAllOrder();


}
