package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminInsert
 */
@WebServlet("/UserInsert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String button = request.getParameter("s2");
		if(button.equals("insert")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","root");
                
				String name =  request.getParameter("name");
				
				String emailid = request.getParameter("emailid");
				
				String password = request.getParameter("password");
				
				String country = request.getParameter("country");
				
				String address = request.getParameter("address");
				
				String pincode = request.getParameter("pincode");
				PreparedStatement ps = c1.prepareStatement("insert into userr values(?,?,?,?,?,?)");
			
				
				ps.setString(1,name);
				ps.setString(2,emailid);
				ps.setString(3, password);
				ps.setString(4,country);
				ps.setString(5,address);
				ps.setString(6,pincode);
				
				int k = ps.executeUpdate();
				
				if(k>0) {
				
					pw.println("<h5 style = 'color:red;text-align:center'>inserted values succesfully</h5> ");
					RequestDispatcher rd= request.getRequestDispatcher("User.html");
					rd.include(request, response);
				}
				else {
					pw.println("check again for the errors");
				}
				
				ps.close();
				c1.close();
	
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(button.equals("Login")) {
			RequestDispatcher rd= request.getRequestDispatcher("UserLogin.html");
			rd.forward(request, response);
		
	
	}
	
	
	
	}
}


