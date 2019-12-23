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
@WebServlet("/login2")
public class LoginServlet  extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl(); 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //Get the form data
		 int empId=Integer.parseInt(req.getParameter("empId"));
		 String password=req.getParameter("password");
		 
		 EmployeeInfoBean employeeInfoBean=service.authenticate(empId, password);
		 if (employeeInfoBean != null) {
			 //valid credentials
			 HttpSession session=req.getSession(true);
			 session.setAttribute("employeeInfoBean", employeeInfoBean);
			 session.setMaxInactiveInterval(60);
			 
			 req.getRequestDispatcher("./homePageJsp.jsp").forward(req, resp);
			 	
		}
		 else
		 {
			 //invalid credentilas
			 req.setAttribute("msg", "Invalid Credentials!");
			 req.getRequestDispatcher("./loginForm").forward(req, resp);
		 }
	} //end of dopost
	

}//end of class
