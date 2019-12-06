package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUser {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//Load the Driver
		try {
			//Driver driver=new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded....");
			
			//Get the DBConnection
			
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6";
			System.out.println("Enter DB user and password");
			String user=sc.nextLine();
			String password=sc.nextLine();
			conn=DriverManager.getConnection(dbUrl,user,password);
			System.out.println("connection established");
			
			//Issue Sql Query
			String query="delete from users_info where userid=? and password=?";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter UserId..");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("Enter password");
			pstmt.setString(2, sc.nextLine());
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println("User Deleted");
			}
			else
			{
				System.out.println("Something wrong");
			}
			
		} 
		
		
		
		
		catch (Exception e) {
			
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
