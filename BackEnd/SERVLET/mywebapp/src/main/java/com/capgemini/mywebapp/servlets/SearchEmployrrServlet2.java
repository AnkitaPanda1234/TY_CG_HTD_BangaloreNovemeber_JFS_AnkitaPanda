package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/searchEmployee2")
public class SearchEmployrrServlet2 extends HttpServlet {
	private EmployeeService employeeService=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//to check if the user is logged in or not
		HttpSession session=req.getSession(false); //to validate the session it is false
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(session !=null)
		{
			// valid session
			String empIdVal=req.getParameter("empId");
			int empId=Integer.parseInt(empIdVal);
			
			 EmployeeInfoBean  employeeInfoBean =employeeService.searchEmployee(empId);
			 if(employeeInfoBean !=null)
			 {
				 out.println("<h3 style='color: green'>Employee id"+empId+"Found-<h3>");
				 out.println("Name="+employeeInfoBean.getName());
				 out.println("<br>Age="+employeeInfoBean.getAge());
				 out.println("<br>Salary ="+employeeInfoBean.getSalary());
				 out.println("<br>Designation ="+employeeInfoBean.getDesignation());
			 } else
			 {
				out.println("<h3 style='color:red'>Employee ID"+empId+"Not Found!</h3>"); 
			 }
			 
			 
		}
		else
		{
			//Invalid session
			//go to login page
			out.println("Please LogIn First!");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
			
		}
		out.println("</body>");
		out.println("</html>");
		
	} //Enf of doGet
	
	
	
	
	
	

}//
