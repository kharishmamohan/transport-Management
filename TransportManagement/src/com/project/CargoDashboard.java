package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CargoDashboard
 */
@WebServlet("/CargoDashboard")
public class CargoDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String button = request.getParameter("s3");
		String type = request.getParameter("Type");
		if(button.equals("Land Transport")) {
			RequestDispatcher rd= request.getRequestDispatcher("Transport.html");
			rd.forward(request, response);
		}
		
		else if(button.equals("Ship Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("ShipTransport.html");
			rd.forward(request, response);
		}
		else if(button.equals("Air Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("AirTransport.html");
			rd.forward(request, response);
		}

		else if(button.equals("Update Land Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("UpdateTransport.html");
			rd.forward(request, response);
		}
		
		else if(button.equals("Update Ship Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("UpdateShipTransport.html");
			rd.forward(request, response);
		}
		else if(button.equals("Update Air Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("UpdateAirTransport.html");
			rd.forward(request, response);
		}
		else if(button.equals("Delete Land Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("DeleteTransport.html");
			rd.forward(request, response);
		}
		else if(button.equals("Delete Ship Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("DeleteShipTransport.html");
			rd.forward(request, response);
		}
		else if(button.equals("Delete Air Transport")) {
			RequestDispatcher rd=request.getRequestDispatcher("DeleteAirTransport.html");
			rd.forward(request, response);
		}
		else if(button.equals("Land Transport1")) {
try {
				
				pw.println("<html><body>");
				pw.println("<form>");
				
				
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
				pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> </tr> ");
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");
				
				
				
				PreparedStatement ps = c1.prepareStatement("select *  from landtransport ");
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
							"</td><td>" + rs.getString(7) +"</td></tr>");
				}
				pw.println("</table>");
				pw.println("<br/>");	
				
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		

		}
	
		else if(button.equals("Ship Transport1")) {
			
            try {
				
				pw.println("<html><body>");
				pw.println("<form>");
				
				
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
				pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <tr> ");
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");
								
				
				PreparedStatement ps = c1.prepareStatement("select *  from shiptransport ");
				
		         ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
							"</td><td>" + rs.getString(7) +"</td></tr>");
				}
				pw.println("</table>");
				pw.println("<br/>");	
				
			}
		
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}
      
		else if(button.equals("Air Transport1")) {
			

           try {
			
			pw.println("<html><body>");
				pw.println("<form>");
				
			
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
				pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <tr> ");
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");
				
				
				
				PreparedStatement ps = c1.prepareStatement("select *  from airtransport ");
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
							"</td><td>" + rs.getString(7) +"</td></tr>");
			}
				pw.println("</table>");
				pw.println("<br/>");	
				
			}
			
			catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
	
		
	
	
	
	}
	
	
}
	
