package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 @WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //	String url="http://www.facebook.com";
		//String url="//www.facebook.com"; External Resource
		String url="./currentDate"; // Internal Resource
		
		resp.sendRedirect(url); //to redirect 
		
	} //end of doget

} // end of class
