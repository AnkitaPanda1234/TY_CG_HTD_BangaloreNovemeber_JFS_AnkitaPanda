package com.capgemini.mywebapp.servletforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/updateEmployee2")
public class UpdateEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session != null) {
			//valid session
			  //get the form data
			int empId=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			String ageVal=req.getParameter("age");
			String salaryVal=req.getParameter("salary");
			String desgination=req.getParameter("designation");
			String password=req.getParameter("password");
			
			
			EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
			
			employeeInfoBean.setEmpId(empId);
			employeeInfoBean.setName(name);
			if(ageVal !=null && !ageVal.isEmpty())
			{
				int age=Integer.parseInt(ageVal);
				employeeInfoBean.setAge(age);
			}
			if(salaryVal !=null && !salaryVal.isEmpty())
			{
				int salary=Integer.parseInt(salaryVal);
				employeeInfoBean.setSalary(salary);
			}
			employeeInfoBean.setDesignation(desgination);
			employeeInfoBean.setPassword(password);
			
			boolean isUpdated=service.updateEmployee(employeeInfoBean);
			if(isUpdated)
			{
				req.setAttribute("msg", "employee details updated seccessfullu");
			}
			else
			{
				req.setAttribute("msg", "please tryb again");
			
			}
			
			req.getRequestDispatcher("./updateEmpJsp").forward(req, resp);
			
		} 
		else
		{
			//invalid session
			req.setAttribute("msg", "please logged in first");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		} 
		
	} //end of dopost
	

} //end of class
