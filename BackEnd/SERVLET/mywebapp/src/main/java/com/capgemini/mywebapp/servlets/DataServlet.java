package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date=new Date();  //current time ade date
		
		//  1st way to Get The context param
		//ServletContext context=getServletContext();//it is interface
		//getServletContext() present in Generic Servlet
		// 2nd way to get the context param
	ServletContext context=req.getServletContext();	
	String contextParamVal=	context.getInitParameter("myContextParam");
	
	//Get Config Param
	ServletConfig config=getServletConfig();
	String configparamVal=config.getInitParameter("myConfigParam");
		
		
		
		resp.setContentType("text/html");
		resp.setHeader("refresh", "1");
		PrintWriter out=resp.getWriter(); //getWritter returntype printwritter
		out.print("<html>");
		out.print("<h2>Current System Date & Time - <br>" +date+"</h2>");
		//display context param value
		out.println("<br><br>Context Param Value ="+contextParamVal);
		//displaying config param value
		out.println("<br><br>Config Param Value ="+configparamVal);
		out.print("</html>");
	}//end of doget
	

}
