package com.cap.empspringmvc.dao;

import java.util.List;

import com.cap.empspringmvc.bean.EmployeeBean;

public interface EmployeeDAO {
	
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	//public EmployeeBean getEmployee(String email);
	public List<EmployeeBean> getEmployess(String key);
	public boolean changePassword(int id,String password);

}
