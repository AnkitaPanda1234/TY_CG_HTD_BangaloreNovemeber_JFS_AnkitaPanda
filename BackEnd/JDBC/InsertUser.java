package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		Scanner sc=new Scanner(System.in);
		
		try {
			//load the driver
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded....");
			
			//get db connection
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6";
			System.out.println("Enter DB user and password");
			
			String user=sc.nextLine();
			String password=sc.nextLine();
			
			conn=DriverManager.getConnection(dbUrl,user,password);
			System.out.println("connection established");
			
			//Issue sql queries	
			String query="insert into  users_info values(?,?,?,?)";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter UserId..");
			
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Username");
			
			pstmt.setString(2, sc.nextLine());
			System.out.println("Enter Email");
			
			pstmt.setString(3, sc.nextLine());
			System.out.println("Enter password");
			
			pstmt.setString(4, sc.nextLine());
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println("User Inserted");
			}
			else
			{
				System.out.println("Something wrong");
			}
		} 
		
		
		catch (SQLException e) {
			
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
	}
	}

}
