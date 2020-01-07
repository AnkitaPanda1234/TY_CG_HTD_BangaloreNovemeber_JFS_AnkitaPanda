package com.cap.empspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cap.empspringmvc.bean.EmployeeAddressBean;
import com.cap.empspringmvc.bean.EmployeeBean;
import com.cap.empspringmvc.dao.EmployeeDAO;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired   //no need to creat factory it search for the type and take the ref variable
	private EmployeeDAO dao;
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

	@Override
	public EmployeeBean auth(String email, String password) {
		
	
		return dao.auth(email,password);
	}

	@Override
	public boolean register(EmployeeBean bean) {
		
		String encodedPassword=encoder.encode(bean.getPassword());
		bean.setPassword(encodedPassword);
		List<EmployeeAddressBean> addressBeans=bean.getAddressBeans();
		for (EmployeeAddressBean employeeAddressBean : addressBeans) {
			employeeAddressBean.setBean(bean);
			
		}
		return dao.register(bean);
	}

	@Override
	public List<EmployeeBean> getEmployess(String key) {
		
		return dao.getEmployess(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		
		return dao.changePassword(id, encoder.encode(password));
		//it is a hashing technique .hashing is a part of encryption
	}

}
