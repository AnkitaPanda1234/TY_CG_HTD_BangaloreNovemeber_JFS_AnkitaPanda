package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get the query string
		String idVal=req.getParameter("id");
		

		// Get The context param
		ServletContext context=getServletContext();//it is interface
	String contextParamVal=	context.getInitParameter("myContextParam");
	
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html");
		out.println("<body>");
		out.println("Employee Id="+idVal);
		out.println("<br>Name=Ankita");
		out.println("<br>Salary=10000");
		
		out.println("<br><br>Context Param Value ="+contextParamVal);
		out.println("</body>");
		out.println("</html>");
	} //end of doget

} //end of class
