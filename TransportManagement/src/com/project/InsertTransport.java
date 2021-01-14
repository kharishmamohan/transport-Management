package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertTransport
 */
@WebServlet("/InsertTransport")
public class InsertTransport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String button = request.getParameter("s3");
		if(button.equals("Proceed")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");

		String fromlocation =request.getParameter("Location");
		String tolocation  = request.getParameter("Location1");
		String vehicleid = request.getParameter("Id");
		int weightofcargo=Integer.parseInt(request.getParameter("Weight"));
		String journeyoftime=request.getParameter("Time");
		int price=Integer.parseInt(request.getParameter("Price"));
		String Dateofjourney=request.getParameter("Doj");
		
		PreparedStatement ps=c1.prepareStatement("insert into landtransport values(?,?,?,?,?,?,?)");
		
		ps.setString(1,fromlocation);
		ps.setString(2,tolocation);
		ps.setString(3,vehicleid);
		ps.setInt(4, weightofcargo);
		ps.setString(5, journeyoftime);
		ps.setInt(6, price);
		ps.setString(7, Dateofjourney);
	

		int k=ps.executeUpdate();
        if(k>0) {
        
        	
        	pw.println("<h5 style = 'color:red;text-align:center'>inserted values succesfully</h5> ");
        	RequestDispatcher rd= request.getRequestDispatcher("Transport.html");
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