package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.Dao.EmployeeDao;
import com.capgemini.mywebapp.Dao.EmployeeDaoImpl;
import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public class EmployeeServiceImpl  implements EmployeeService{
	private EmployeeDao dao=new EmployeeDaoImpl();
	@Override
	public EmployeeInfoBean searchEmployee(int empid) {
		return dao.searchEmployee(empid);
			
	}
	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		
		return dao.authenticate(empId, password);
	}
	@Override
	public boolean deleteEmployee(int empId) {
		return dao.deleteEmployee(empId);
	}
	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}
	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<EmployeeInfoBean> getAllEmplpyees() {
		return dao.getAllEmplpyees();
	}
	

}
