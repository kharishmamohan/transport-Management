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
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
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
			
			if(Login.aLog(email, password)) {
				RequestDispatcher rd= request.getRequestDispatcher("UserDashboard.html");
				rd.forward(request, response);	
				ServletContext sc= getServletContext();
				sc.setAttribute("email",email);
					
				}
			
			else {
				pw.println("the details are not correct");
				RequestDispatcher rd= request.getRequestDispatcher("Admin.html");
				rd.include(request, response);
			
			
			}
				
				
	}

	}
}