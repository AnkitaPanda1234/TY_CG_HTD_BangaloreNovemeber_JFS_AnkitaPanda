package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspringrest.dao.ContractDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.InventoryDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.ScheduleDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.ContractBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.ScheduleBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.exception.SchedulerException;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleDAO scheduleDao;

	@Autowired
	private ContractDAO contractDao;

	@Autowired
	private CustomerDAO customerDao;
	@Autowired
	private InventoryDAO inventoryDao;

	@Override
	public boolean addSchedule(ScheduleBean scheduleBean) {

		int contractId = scheduleBean.getContractId();
		ContractBean contractBean = null;
		InventoryBean inventoryBean = null;
		long availableQuantity;
		long finalQunatity = 0;
		boolean addFlag = false;
		int productId = 0;
		try {
			contractBean = contractDao.viewContract(contractId);
		} catch (NoResultException  e) {
			System.out.println(e.getMessage());
		}
		if (contractBean == null) {
			throw new CustomerException("Contract Details  not found for  id:" + contractId );
		} else {

			int customerId = contractBean.getCustomerId();
			productId = contractBean.getProductId();
			int orderId = contractBean.getOrderId();
			String deliveryDate = contractBean.getDeliveryDate();
			long orderQunatity = contractBean.getQunatity();

			CustomerBean cstBean = null;
			try {
				cstBean = customerDao.getCustomer(customerId);
			} catch (NoResultException e) {
				System.out.println(e.getMessage());
			}

			if (cstBean == null) {
				throw new CustomerException("customer not found for customer id:" + customerId);
			}

			try {
				inventoryBean = inventoryDao.getInventory(productId);
			} catch (NoResultException e) {
				System.out.println(e.getMessage());
			}

			if (inventoryBean == null) {
				throw new CustomerException("product not found for productId id:" + productId);
			} else {
				availableQuantity = inventoryBean.getProductquantity();
			}

			if (availableQuantity < orderQunatity) {
				throw new CustomerException("Currently don't have the total product in our stock ");
			} else if (availableQuantity > orderQunatity) {
				finalQunatity = availableQuantity - orderQunatity;
			}

			scheduleBean.setCustomerId(customerId);
			scheduleBean.setOrderId(orderId);
			scheduleBean.setProductId(productId);
			scheduleBean.setDeliveryDate(deliveryDate);
			scheduleBean.setQuantity(orderQunatity);
			scheduleBean.setStatus("Scheduled");

			addFlag = scheduleDao.addSchedule(scheduleBean);
		}
		if (addFlag) {
			inventoryBean.setProductquantity(finalQunatity);
			inventoryDao.modifyInventory(productId, inventoryBean);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ScheduleBean searchSchedule(int schedulerid) throws SchedulerException {

		return scheduleDao.searchSchedule(schedulerid);
	}

	@Override
	public List<ScheduleBean> getAllSchedule() throws SchedulerException {

		return scheduleDao.getAllSchedule();
	}

	@Override
	public boolean deleteSchedule(int scheduleId) throws SchedulerException {
		// return scheduleDao.deleteSchedule(scheduleId);

		ScheduleBean scheduleBean = null;
		InventoryBean inventoryBean = null;
		boolean deleteFlag = false;
		long availableQuantity = 0;
		try {
			scheduleBean = scheduleDao.searchSchedule(scheduleId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (scheduleBean == null) {
			throw new CustomerException("Schedule not found for  id:" + scheduleId);
		} else {
			deleteFlag = scheduleDao.deleteSchedule(scheduleId);
		}
		if (deleteFlag) {

			int productId = scheduleBean.getProductId();
			long cancelQunatity = scheduleBean.getQuantity();

			try {
				inventoryBean = inventoryDao.getInventory(productId);
			} catch (NoResultException e) {
				System.out.println(e.getMessage());
			}

			if (inventoryBean == null) {
				throw new CustomerException("product not found for productId id:" + productId);
			} else {
				availableQuantity = inventoryBean.getProductquantity();
			}
			// System.out.println("SCHEDULER SERVICE
			// availableQuantity==>"+availableQuantity+"cancelQunatity==>"+cancelQunatity);
			long finalQunatity = cancelQunatity + availableQuantity;

			inventoryBean.setProductquantity(finalQunatity);
			inventoryDao.modifyInventory(productId, inventoryBean);

			return true;
		} else {
			return false;
		}
	}

}
