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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl(); 



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get the form data
		String empIdval=req.getParameter("empId");
		String password=req.getParameter("password");

		int empId=Integer.parseInt(empIdval); //convert string to int

		EmployeeInfoBean employoInfobean =service.authenticate(empId, password);
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(employoInfobean !=null)
		{
			//valid credentials
			HttpSession session =req.getSession(true); //create session it is true 
			session.setAttribute("employoInfobean", employoInfobean); //get all the empresult
			
			
			out.println(" <h3 style='color:blue'>Welcome" +employoInfobean.getName()+" !</h2>");
			out.println("<br><a href='addEmployeeForm.html'> Add Employee</a>");
			out.println("<br><a href='#'> Update Employee</a>");
			out.println("<br><a href='./searchEmployeeForm.html'> Search Employee</a>");
			out.println("<br><a href='./deleteEmployeeForm.html'> Delete Employee</a>");
			out.println("<br><a href='#'> See All Employee</a>");
			out.println("<br><br><a href='./logout'> Logout</a>");

		}
		else
		{
			//Invalid credentials
			out.println("<h3 style='color:red'> Invalid credentilas</h3>");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
		}
		out.println("</body>");
		out.println("</html>");


	} //end of dopost






} //end of class
