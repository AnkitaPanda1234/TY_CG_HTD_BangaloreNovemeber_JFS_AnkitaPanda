package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl(); 
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   HttpSession session=req.getSession();
		   if(session!=null)
		   {
			   //valid session
			   int empId= Integer.parseInt(req.getParameter("empId"));
			   PrintWriter out=resp.getWriter();
			   out.println("<html>");
			   out.println("<body>");
			   if(service.deleteEmployee(empId))
			   {
				   out.println("<h3 style='color:red'>Employee Record for " +empId +"Deleted </h3>");
			   }
			   else
			   {
				   out.println("<h3 style='color:red'>Employee Record " +empId +"Not Found <h3>"); 
			   }
			   out.println("</body>");
			   out.println("</html>");
			   req.getRequestDispatcher("./deleteEmployeeForm.html").include(req, resp);
		   }
		   else
		   {
			   //Invalid session
			   PrintWriter out=resp.getWriter();
			   out.println("<html>");
			   out.println("<body>");
			   out.println("<h3 style='color:red'> Please Login First!</h3>");
			   out.println("</body>");
			   out.println("</html>");
			   req.getRequestDispatcher("./loginPage.html").include(req, resp);
			   
		   }
		
	} //end of doGet

} //end of class
