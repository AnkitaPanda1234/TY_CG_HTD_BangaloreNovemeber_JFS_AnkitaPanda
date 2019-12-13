package com.cap.phonesimulator.services;

import java.util.List;

import com.cap.phonesimulator.bean.ContactBean;

public interface ContactServices {
	
	List<ContactBean> getAllContact();
	public boolean searchContact(String name);
	public boolean addContact(ContactBean contact);
	public boolean modifyContact(String name, ContactBean bean);
	public boolean deleteContact(int number);
	

}
