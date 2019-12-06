package com.caps.jdbc;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class EvolvedJDBDv2 {

	public static void main(String[] args) {
		FileReader reader=null;
		Properties prop=null;
		try {
			reader =new FileReader("db.properties");
			 prop =new Properties();
			prop.load(reader);  //load properties
			Class.forName(prop.getProperty("driverClass")); //get properties
			System.out.println("driver loaded...");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query1"))) 
		{
			while(rs.next())
			{
				System.out.println("Userid: "+rs.getInt(1));
				System.out.println("Username: "+rs.getString("username"));
				System.out.println("email :"+rs.getString(3));
				System.out.println("......."); 
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
