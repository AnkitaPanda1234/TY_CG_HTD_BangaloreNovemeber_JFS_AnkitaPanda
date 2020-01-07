package com.cap.empspringmvc.service;

import java.util.List;

import com.cap.empspringmvc.bean.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean> getEmployess(String key);
	public boolean changePassword(int id,String password);

}
