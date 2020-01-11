package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao.OrderDao;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderBean;
@Service
public class OrderServiceImpl  implements OrderService{
  @Autowired
  private OrderDao dao;
	@Override
	public boolean addOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return dao.addOrder(order);
	}

	@Override
	public OrderBean getOrder(int orderid) {
		// TODO Auto-generated method stub
		return dao.getOrder(orderid);
	}

	@Override
	public List<OrderBean> getAllOrder() {
		// TODO Auto-generated method stub
		return dao.getAllOrder();
	}

}
