package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeeUtility {
// this method is used to establish a connection between database
	
	public static Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = 
					DriverManager.getConnection("jdbc:postgresql://localhost:5432/JdbcDemo_tb1", "postgres", "Srini#123");
			        
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
