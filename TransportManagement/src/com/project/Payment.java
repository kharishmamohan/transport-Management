package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		ServletContext sc1 = getServletContext();
		String refmail = (String)sc1.getAttribute("email");
		
		
		pw.println("payment got sucess");
		ServletContext sc2 = getServletContext();
		int Total = (Integer)sc1.getAttribute("t");
		
		pw.println(refmail+""+Total);

		
	      try {
	    	  pw.println("<table border='1' cellspacing= '3' cellpadding='2'>");
			 pw.println("<tr> <td> NAME </td>  <td> COUNTRY </td> <td> ADDRESS </td>   <td> PINCODE </td> </tr> ");
	    	    Class.forName("com.mysql.jdbc.Driver");
		        Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");
		
		     PreparedStatement ps = c1.prepareStatement("select *  from userr where emailid=?");
		     
		     ps.setString(1,refmail );
		     
		     ResultSet rs = ps.executeQuery();
           while (rs.next()) {

				pw.println("<tr><td> " + rs.getString(1) + "</td><td>"+ rs.getString(4) + "</td><td>" + rs.getString(5)+ "</td><td>" + rs.getInt(6)+"</td></tr>");
    	   
    	   pw.println("The name is"+ rs.getString(1));
    	   pw.println("The country is"+ rs.getString(4));
    	   pw.println("The Address is"+ rs.getString(5));
    	   pw.println("The Pincode is"+ rs.getInt(6));
          }
	
	    }
	   catch (Exception e) {
	
		e.printStackTrace();
	   }
	
	}

}
