package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="./currentDate";
		//String url="www.facebook.com" it can't done by external resource
		//for forward request create object of RequestDispatcher
		RequestDispatcher dispatcher= req.getRequestDispatcher(url);
		
		dispatcher.forward(req, resp);
		
		
		
	} //End of doget

} //end of class
