package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyFirstJDBC {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
	
		try {
			//Load the Driver
			//Driver driver = new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver); //registered with driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...");
			 
			//Get DBConnection via Driver
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6"+"?user=root&password=root";//compile
			conn=DriverManager.getConnection(dbUrl);
			System.out.println("connection established..");
			
			//Issue SQL query via connection
			String query="select * from users_info";
			stmt = conn.createStatement(); //nonstatic method present in connection
			rs=stmt.executeQuery(query); //query will be converted into statement
			System.out.println("Query Issued...");
			System.out.println("***************");
			
			//Process the Result returned
			while(rs.next())
			{
				System.out.println("userid :"+rs.getInt("userid"));
				System.out.println("userName :"+rs.getString("userName"));
				System.out.println("Email :"+rs.getString("email"));
				System.out.println("***********************");	
			}
			
		     } 
		       catch (Exception e) //checked exception
		       {
			
			    e.printStackTrace();
		        }
		finally {          //close all JDBC Object
			
				try {
					if(conn!=null) 
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try
				{
					if(stmt!=null)
						stmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				try
				{
					if(rs!=null)
						rs.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		

	}

}
