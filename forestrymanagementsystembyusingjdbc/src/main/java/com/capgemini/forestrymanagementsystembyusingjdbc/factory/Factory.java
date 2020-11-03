package com.capgemini.forestrymanagementsystembyusingjdbc.factory;

import com.capgemini.forestrymanagementsystembyusingjdbc.dao.AdminDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.AdminDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.ContractorDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.CustomerDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.HauilerDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.HauilerDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.InventoryDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.InventoryDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.LandDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.LandDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.ScheduleDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.ScheduleDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.AdminServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.AdminServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ContractorServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ContractorServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.CustomerServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.CustomerServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.HauilerService;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.HauilerServiceImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.LandService;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.LandServiceImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ScheduleService;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ScheduleServiceImpl;

/**
 * 
 * @author Ankita Panda
 *
 */
public class Factory {
	/**
	 * 
	 */
	private Factory() {

	}

	public static AdminDAO instanceOfClientDAOImpl() {
		AdminDAO adminDAO = new AdminDAOImpl();
		return adminDAO;
	}

	public static AdminServices instanceOfClientServices() {
		AdminServices service = new AdminServicesImpl();
		return service;
	}

	public static CustomerDAO instanceOfCustomerDAOImpl() {
		CustomerDAO dao = new CustomerDAOImpl();
		return dao;
	}

	public static InventoryServices instanceOfInventoryServices() {
		InventoryServices service = new InventoryServicesImpl();
		return service;
	}

	public static InventoryDAO instanceOfInventoryDAOImpl() {
		InventoryDAO dao = new InventoryDAOImpl();
		return dao;
	}

	public static CustomerServices instanceOfCustomerServices() {
		CustomerServices service = new CustomerServicesImpl();
		return service;
	}

	public static ContractorDAO instanceOfContractorDAOImpl() {
		ContractorDAO dao = new ContractorDAOImpl();
		return dao;
	}

	public static ContractorServices instanceOfContractorServices() {
		ContractorServices service = new ContractorServicesImpl();
		return service;
	}

	public static AdminDAO instanceOfAdminDAOImpl() {
		AdminDAO dao = new AdminDAOImpl();
		return dao;
	}

	public static AdminServices instanceOfAdminServices() {
		AdminServices service = new AdminServicesImpl();
		return service;
	}

	public static LandService instanceOfLandServices() {
		LandService service = new LandServiceImpl();
		return service;
	}

	public static LandDAO instanceOfLandDaoImpl() {
		LandDAO dao = new LandDAOImpl();
		return dao;
	}



	public static HauilerService instanceOfHauilerService() {
		HauilerService service = new HauilerServiceImpl();
		return service;
	}

	public static HauilerDAO instanceOfHauilerServiceImpl() {
		HauilerDAO dao = new HauilerDAOImpl();
		return dao;
	}

	public static ScheduleService instanceOfScheduleService() {
		ScheduleService service = new ScheduleServiceImpl();
		return service;
	}

	public static ScheduleDAO instanceOfScheduleDAOImpl() {
		ScheduleDAO dao = new ScheduleDAOImpl();
		return dao;
	}

}
