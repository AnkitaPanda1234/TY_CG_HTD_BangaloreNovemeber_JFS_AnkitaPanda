package com.capgemini.forestrymanagementsystembyusingcollection.factory;

import com.capgemini.forestrymanagementsystembyusingcollection.dao.AdminDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.AdminDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ClientDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ClientDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.HauilerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.HauilerDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.LandDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.LandDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ScheduleDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ScheduleDAOImpl;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.SchedulerDAOImpl;

public class ForestDaoManager {
	
	public static CustomerDAO instanceofCustomerDAOImpl()
	{
		return new CustomerDAOImpl();
	}
	
	public static ContractorDAO instanceofContractorDAOImpl()
	{
		return new ContractorDAOImpl();
	}
	public static ProductDAO instanceofProductDAOImpl()
	{
		return new ProductDAOImpl();
	}
	
	public static LandDAO instanceofLandDAOImpl()
	{
		return new LandDAOImpl();
	}
	public static AdminDAO instanceofAdminDAOImpl()
	{
		return new AdminDAOImpl();
	}
	
	public static ClientDAO instanceofClientDAOImpl() {
		return new ClientDAOImpl();
	}
	
	public static SchedulerDAO instanceofSchedulerDAOImpl()
	{
		return new SchedulerDAOImpl();
	}
	
	public static HauilerDAO instanceofHauilerDAOImpl()
	{
		return new HauilerDAOImpl();
	}
	

	public static ScheduleDAO instanceofScheduleDAOImpl()
	{
		return new ScheduleDAOImpl();
	}
	
	
	
}

