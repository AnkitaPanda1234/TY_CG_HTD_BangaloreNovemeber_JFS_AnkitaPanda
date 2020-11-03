package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.forestrymanagementsystemspringrest.dao.AdminDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;
@Service
public class AdminServiceImpl  implements AdminService{
	@Autowired
	private AdminDAO dao;

	@Override
	public boolean clientregister(UserBean clientBean) {
		// TODO Auto-generated method stub
		return dao.clientregister(clientBean);
	}

	@Override
	public boolean schedulerregister(UserBean schedulerBean) {
		// TODO Auto-generated method stub
		return dao.schedulerregister(schedulerBean);
	}

	@Override
	public boolean removeClient(int id) {
		// TODO Auto-generated method stub
		return dao.removeClient(id);
	}

	@Override
	public List<UserBean> showClients() {
		// TODO Auto-generated method stub
		return dao.showClients();
	}

	@Override
	public boolean removeScheduler(int id) {
		// TODO Auto-generated method stub
		return dao.removeClient(id);
	}

	@Override
	public List<UserBean> showScheduler() {
		// TODO Auto-generated method stub
		return dao.showScheduler();
	}
	
	

	
	

}
