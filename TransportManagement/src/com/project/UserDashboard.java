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
 * Servlet implementation class UserDashboard
 */
@WebServlet("/UserDashboard")
public class UserDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String button = request.getParameter("s6");
		pw.println("<html><body>");
		 if(button.equals("Land Transport")) {
			 
			try {
				
				
				pw.println("<form>");
				
				
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
				pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <td> TOTAL </td><tr> ");
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","root");
				
				
				
				PreparedStatement ps = c1.prepareStatement("select *  from landtransport ");
				
				ResultSet rs = ps.executeQuery();
				int t=0;
				while(rs.next()) {
					
			int w=rs.getInt(4);
			int p=rs.getInt(6);
			     t=w*p;
			
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
							"</td><td>" + rs.getString(7) +"</td><td>"+t+"</td></tr>");
				}
				
				ServletContext sc1 = getServletContext();
				sc1.setAttribute("t",t);
				

				
				pw.println("</table>");
				pw.println("<br/>");
				
				
				
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(button.equals("Ship Transport")) {
		
             try {
				
				
				pw.println("<form>");
				
				
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
				pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <td> TOTAL </td><tr> ");
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","root");
				
				
				
				PreparedStatement ps = c1.prepareStatement("select *  from shiptransport ");
				
			     ResultSet rs = ps.executeQuery();
			
			     int t=0;
			    while(rs.next()) {
				
		        int w=rs.getInt(4);
		        int p=rs.getInt(6);
		             t=w*p;
							
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
							"</td><td>" + rs.getString(7)+"</td><td>"+t+"</td></tr>");
				}
			
		     	ServletContext sc1 = getServletContext();
			    sc1.setAttribute("t",t);
			
				pw.println("</table>");
				pw.println("<br/>");	
			
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
         	

		}
       
		else if(button.equals("Air Transport")) {
			

            try {
				
				
				pw.println("<form>");
				
				
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
				pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <td> TOTAL </td><tr> ");
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","root");
				
				
				
				PreparedStatement ps = c1.prepareStatement("select *  from airtransport ");
				
				ResultSet rs = ps.executeQuery();
				  int t=0;
				    while(rs.next()) {
					
			        int w=rs.getInt(4);
			        int p=rs.getInt(6);
			             t=w*p;
					
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
							"</td><td>" + rs.getString(7)+"</td><td>"+t+"</td></tr>");
				}
				
				ServletContext sc1 = getServletContext();
			    sc1.setAttribute("t",t);
			
				pw.println("</table>");
				pw.println("<br/>");
			
				
			}
			
			catch(Exception e) {
				e.printStackTrace();
		
		}
         
		}
		
		
		
		else if(button.equals("Proceed")) {
			String k=request.getParameter("Search");
			if(k.equals("Bus")) {
			
				try {
					
					
					pw.println("<form>");
					
				
							
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","root");

					
				String fromlocation = request.getParameter("Location");
				String tolocation = request.getParameter("Location1");
				
			
				
				PreparedStatement ps=c1.prepareStatement("select * from landtransport where from_location =? and to_location=?");
				
				ps.setString(1,fromlocation);
				ps.setString(2,tolocation);
				
				ResultSet rs= ps.executeQuery();
				
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
				pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <tr> ");
						
				while(rs.next()) {
					
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
					"</td><td>" + rs.getString(7) +"</td></tr>");
					
				} 
			
				}
				
				catch(Exception e) {
			     e.printStackTrace();
			
				}	
	
				
			}
			
			else if(k.equals("Ship")) {
				
				try {
					
					
					pw.println("<form>");
					
				
				pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
					pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <tr> ");
					
											
					Class.forName("com.mysql.jdbc.Driver");
					Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","root");

					
				String fromlocation = request.getParameter("Location");
				String tolocation = request.getParameter("Location1");
				
			
				
				PreparedStatement ps=c1.prepareStatement("select * from shiptransport where from_location =? and to_location=?");
				
				ps.setString(1,fromlocation);
				ps.setString(2,tolocation);
				
				ResultSet rs= ps.executeQuery();
				
				while(rs.next()) {
					
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
					"</td><td>" + rs.getString(7) +"</td></tr>");
					
				}
			
				
				}
				
				catch(Exception e) {
			     e.printStackTrace();
			
				}	
	
				
			}
			
			else if(k.equals("Air")) {
				
				try {
					
					
					pw.println("<form>");
					
				
					pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
					pw.println("<tr> <td> FROM LOCATION </td>  <td> TO LOCATION </td> <td> VEHICLE ID </td>   <td> WEIGHTOFCARGO </td>  <td> JOURNEY TIME </td> <td> PRICE </td> <td> DATEOFJOURNEY </td> <tr> ");
					
					
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport","root","root");

					
				String fromlocation = request.getParameter("Location");
				String tolocation = request.getParameter("Location1");
				
			
				
				PreparedStatement ps=c1.prepareStatement("select * from airtransport where from_location =? and to_location=?");
				
				ps.setString(1,fromlocation);
				ps.setString(2,tolocation);
				
				ResultSet rs= ps.executeQuery();
				
				while(rs.next()) {
					
					pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3)+ "</td><td>" + rs.getInt(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+
					"</td><td>" + rs.getString(7) +"</td></tr>");
					
				} 
				pw.println("</table");
				pw.println("<br/>");
				
				
				}
				
				catch(Exception e) {
			     e.printStackTrace();
			
				}	
	
				
			}
			
		}
		
		 pw.println("<form action = 'UserDashboard.html'>");
			pw.println("<input type='submit' value = 'Back To Dashboard' name = 's6'/>");
			pw.println("</form>");
			pw.println("<form action = 'Payment.html'>");
			pw.println("<input type='submit' value = 'Make A Payment' name = 's11'/>");
			pw.println("</form>");
			
		pw.println("</body>");

}
}
