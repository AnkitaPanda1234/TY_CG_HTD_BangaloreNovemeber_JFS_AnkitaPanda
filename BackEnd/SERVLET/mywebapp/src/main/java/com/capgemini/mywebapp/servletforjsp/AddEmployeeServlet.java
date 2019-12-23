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
@WebServlet("/addEmployee2")
public class AddEmployeeServlet  extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			//valid session
			//get the form data
			int empId=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			double salary=Double.parseDouble(req.getParameter("salary"));
			String desgination=req.getParameter("designation");
			String password=req.getParameter("password");
			EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
			
			employeeInfoBean.setEmpId(empId);
			employeeInfoBean.setName(name);
			employeeInfoBean.setAge(age);
			employeeInfoBean.setSalary(salary);
			employeeInfoBean.setDesignation(desgination);
			employeeInfoBean.setPassword(password);
			boolean isAdded=service.addEmployee(employeeInfoBean);
			if(isAdded) {
			req.setAttribute("msg", "Emploee Added sucessfully");
			req.getRequestDispatcher("./addEmpJspForm.jsp").forward(req, resp);
		    }
		else
		{
			req.setAttribute("msg", "Unabe to insert record");
			req.getRequestDispatcher("./addEmpJspForm.jsp");
		}
		}
		else
		{
			//invalid session
			req.setAttribute("msg", "please logged in first");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}
	
}


