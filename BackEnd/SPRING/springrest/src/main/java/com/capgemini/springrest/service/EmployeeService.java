package com.capgemini.springrest.service;

import java.util.List;

import com.capgemini.springrest.dto.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean> getEmployess(String key);
	public boolean changePassword(int id,String password);
	public boolean deleteEmployee(int id);

}
