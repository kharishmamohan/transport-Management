package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Login;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String button = request.getParameter("s2");
		if(button.equals("Login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if(email.equals("da@gmail.com") && password.equals("12345")) {
				pw.println("<h3>Login success </h3>");
				RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.html");
				rd.include(request, response);
			}
			else {
				pw.println("<h3>Login not success check mail and pass </h3>");
				RequestDispatcher rd = request.getRequestDispatcher("Index.html");
				rd.include(request, response);
				
			}
			
		}
	
	}

}
