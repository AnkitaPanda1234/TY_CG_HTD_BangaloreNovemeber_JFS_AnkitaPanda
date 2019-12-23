package com.capgemini.mywebapp.servletforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout2")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		     
		HttpSession session=req.getSession(false);
		if (session != null) {
			session.invalidate();
			req.setAttribute("msg", "thank you for visiting");
			
		}else
		{
			req.setAttribute("msg", "you are not logged in");
			
		}
		req.getRequestDispatcher("./loginForm").forward(req, resp);
		
		
		
		
		
	} //end of doget
	

}
