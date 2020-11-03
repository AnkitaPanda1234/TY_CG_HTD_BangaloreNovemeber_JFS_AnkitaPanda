package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;

public interface AdminDAO {

	public boolean clientregister(UserBean clientBean);

	public boolean schedulerregister(UserBean schedulerBean);

	public boolean removeClient(int id);

	public List<UserBean> showClients();

	public boolean removeScheduler(int id);

	public List<UserBean> showScheduler();

}
