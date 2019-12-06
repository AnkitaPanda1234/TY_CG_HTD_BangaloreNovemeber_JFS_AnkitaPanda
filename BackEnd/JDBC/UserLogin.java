package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//load the driver
			Driver driver =new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("driver loaded");
			//get DBconnection via Driver
			String dbUrl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			
			System.out.println("Enter userame & password"); //runtime 
			String dbUser=sc.nextLine();
			String dbPass=sc.nextLine();
			
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPass); //polymorphisim,abstraction,inheritance
			System.out.println("connection established");
			//Issue SQL query via connection
			String query="select * from users_info where userid=? and password= ? ";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter UserId..");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("Enter password");
			pstmt.setString(2, sc.nextLine());
			rs=pstmt.executeQuery();
			
			System.out.println("Query issued and executed");
			System.out.println("**************");
			//process the results returned
			if(rs.next())
			{
				System.out.println("username:"+rs.getInt(1));
				System.out.println("username:"+rs.getString(2));
				System.out.println("email :"+rs.getString(3));
			}
			else
			{
				System.out.println("Something wrong");
			}
		     } 
		
		
		catch (SQLException e) 
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
				if(pstmt!=null)
					pstmt.close();
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

	}}
