package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String button=request.getParameter("s1");
	if (button.equals("User")) {
		RequestDispatcher rd = request.getRequestDispatcher("User.html");
		rd.include(request, response);
	}
	
	else if(button.equals("Admin")) {
		RequestDispatcher rd= request.getRequestDispatcher("AdminLogin.html");
		rd.forward(request, response);
		
	}
	
	
	
	}

}
