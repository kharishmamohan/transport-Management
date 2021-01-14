package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAirTransport
 */
@WebServlet("/DeleteAirTransport")
public class DeleteAirTransport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
				
		String FromLocation =request.getParameter("Location");
		
		
		String button = request.getParameter("s3");
		
		 {
			

	 if(button.equals("delete")) {
			
				
			
			pr.println("delete the files");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");

				
				PreparedStatement ps =c1.prepareStatement("delete from airtransport where from_location=?");
				
				ps.setString(1,FromLocation);
			int k=ps.executeUpdate();
			
			if(k>0) {
				
				pr.println("deleted sucess");
				
			}
			
			else {
				pr.println("check the code");

			}
			}
			
		catch(Exception e) {
			
		}
		}
		
		
		
		}
	
	}

}

