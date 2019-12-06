package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserEmailUpdate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			//load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver has been loaded...");
			
			//Get the DB Connection
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6";
			System.out.println("Enter DB User and Password");
			String user=sc.nextLine();
			String password=sc.nextLine();
			conn=DriverManager.getConnection(dbUrl,user,password);
			System.out.println("Connection established..");
			
			//Issue SQL query
			String query="Update users_info set email=? where userid=? and password=? ";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter User Id");
			pstmt.setInt(2,Integer.parseInt(sc.nextLine()));
			System.out.println("Enter the new mail");
			pstmt.setString(1,sc.nextLine());
			System.out.println("Enter Your Password to Update");
			pstmt.setString(3,sc.nextLine());
			
			int count=pstmt.executeUpdate();
			sc.close();
			System.out.println("Query has been issued...");
			//process the results 
			if(count>0)
			{
				System.out.println("Query OK...."+count+ "Rows Effected");
			}
			else
			{
				System.out.println("Something went Wrong");
			}
			
				
		} 
		
		
		
		catch (Exception e) {
			
			e.printStackTrace();
		     }
		
		//close all JDBC Object
              finally {          
			
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
