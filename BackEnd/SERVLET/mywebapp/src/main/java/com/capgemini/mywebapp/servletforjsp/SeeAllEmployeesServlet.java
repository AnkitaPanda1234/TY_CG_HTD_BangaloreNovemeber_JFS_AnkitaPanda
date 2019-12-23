package com.capgemini.mywebapp.servletforjsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/seeAllEmployees")
public class SeeAllEmployeesServlet extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session != null) {
			//valid session
			List<EmployeeInfoBean>employeeList=service.getAllEmplpyees();
			if(employeeList !=null && !employeeList.isEmpty())
			{
				req.setAttribute("employeeList", employeeList);
				
			}
			else
			{
				req.setAttribute("msg", "There Is no Employees Data To Display");
				
			}
			req.getRequestDispatcher("./seeAllEmployeesJsp.jsp").forward(req, resp);
		}
		else
		{
			//invalid session
			req.setAttribute("msg", "Please Logged In First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}//end of session validation
	}

}
