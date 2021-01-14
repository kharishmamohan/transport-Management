package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTransport
 */
@WebServlet("/UpdateTransport")
public class UpdateTransport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	
		String fromlocation =request.getParameter("Location");
		String tolocation  = request.getParameter("Location1");
		String vehicleid = request.getParameter("Id");
		int weightofcargo=Integer.parseInt(request.getParameter("Weight"));
		String journeyoftime=request.getParameter("Time");
		int price=Integer.parseInt(request.getParameter("Price"));
		String Dateofjourney=request.getParameter("Doj");
		String button=request.getParameter("s3");
		if(button.equals("Update")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");
                PreparedStatement ps = c1.prepareStatement("update landtransport set to_location = ?, vehicle_id = ?, weightofcargo = ? , journey_time = ? ,price = ?, dateofjourney = ? where from_location = ?");
				
				
				
				ps.setString(1,tolocation);
				ps.setString(2,vehicleid);
				ps.setInt(3, weightofcargo);
				ps.setString(4, journeyoftime);
				ps.setInt(5, price);
				ps.setString(6, Dateofjourney);
				ps.setString(7,fromlocation);

				int k = ps.executeUpdate();
				
				if(k>0) {
					pw.println("updated transport details");
					
					RequestDispatcher rd= request.getRequestDispatcher("AdminDashboard.html");
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
		
		
			
			
			}

}
