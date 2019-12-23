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
@WebServlet("/deleteEmployee2")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session !=null)
		{
			//valid session
			//get the form data
			 int empId= Integer.parseInt(req.getParameter("empId"));
			
			   boolean isDeleted=service.deleteEmployee(empId);
			  
			if(isDeleted)
			{
				req.setAttribute("msg", "Record for empid " +empId+ "Deleted");
				
				
			}
			else
			{
				req.setAttribute("msg", "Employee Id "+empId+"Not Found");
			}
			req.getRequestDispatcher("./deleteEmpJspForm").forward(req, resp);
		}
		else
		{
			//invalid session
			req.setAttribute("msg", "please log in first");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
		
	}
	

}
