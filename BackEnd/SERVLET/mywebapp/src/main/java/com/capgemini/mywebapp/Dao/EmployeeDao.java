package com.capgemini.mywebapp.Dao;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public interface EmployeeDao {
	public EmployeeInfoBean authenticate(int empId,String password);
	public EmployeeInfoBean searchEmployee(int empid);
	public boolean deleteEmployee(int empId);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	public List<EmployeeInfoBean> getAllEmplpyees();
	
	

}
