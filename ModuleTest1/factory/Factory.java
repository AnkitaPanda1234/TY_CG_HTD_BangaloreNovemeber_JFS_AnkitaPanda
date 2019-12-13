package com.cap.phonesimulator.factory;

import com.cap.phonesimulator.dao.ContactDAO;
import com.cap.phonesimulator.dao.ContactDAOImpl;
import com.cap.phonesimulator.services.ContactServices;
import com.cap.phonesimulator.services.ContactServicesImpl;

public class Factory {
	private Factory()
	{
		
	}
	public static ContactDAO instanceOfContactDAOImpl()
	{
		ContactDAO dao=new ContactDAOImpl();
		return dao;
	}
	public static ContactServices instanceOfContactServicesImple()
	{
	ContactServices services=new ContactServicesImpl();
	      return services;

}
}