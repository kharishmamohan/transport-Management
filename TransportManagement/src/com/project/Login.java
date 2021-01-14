package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

	public static boolean aLog(String email , String password) {
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","6303671632");
			
			
			PreparedStatement ps = c1.prepareStatement("select * from userr where emailid= ? and password = ?");
			
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			flag = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;

	}

}
