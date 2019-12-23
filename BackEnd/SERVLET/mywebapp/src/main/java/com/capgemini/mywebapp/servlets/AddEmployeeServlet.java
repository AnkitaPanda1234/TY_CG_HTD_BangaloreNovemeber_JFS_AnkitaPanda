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

@WebServlet("/addEmployee")
public class AddEmployeeServlet  extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session!=null)
		{
			//valid session
			//Get the form data
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
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			if(isAdded)
			{
				out.println("<h3 style='color:green'>Employee Added sucessfully....</h3>");
			}
			else
			{
				out.println("<h3 style='color:green'> unable to add employee....</h3>");
			}
			out.println("</body>");
			out.println("</html>");
			req.getRequestDispatcher("./addEmployeeForm.html").include(req, resp);
		}
		else
		{
			//Invalid session
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<he style='color:red'>please login first!</h3>");
			out.println("</body>");
			out.println("</html>");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
			
		}
	}

}
