package com.cap.phonesimulator.dao;

import java.util.List;

import com.cap.phonesimulator.bean.ContactBean;

public interface ContactDAO {
	List<ContactBean> getAllContact();
	public List<ContactBean> searchContact(String name);
	public boolean addContact(ContactBean contact);
	public boolean modifyContact(String name, ContactBean bean);
	public boolean deleteContact(int number);
	
	

}
