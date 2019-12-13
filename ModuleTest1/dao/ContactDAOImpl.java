package com.cap.phonesimulator.dao;

import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cap.phonesimulator.bean.ContactBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ContactDAOImpl implements ContactDAO{
	
    Properties prop;
    FileReader reader;
    ContactBean bean;
    public ContactDAOImpl()
    {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		FileReader reader = new FileReader("customer.properties");
    		Properties prop = new Properties();
    		prop.load(reader);
    	}
    catch(Exception e)
    	{
    	e.printStackTrace();
    	}
    
    	
    	
    }
	
	

	@Override
	public List<ContactBean> getAllContact() {
		List<ContactBean> l1=new ArrayList<ContactBean>();
		try (Connection conn=(Connection) DriverManager.getConnection(prop.getProperty("dbUrl"));
				Statement stmt=(Statement) conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query1")))
{
			
		
		while(rs.next())
		{
			ContactBean c1=new ContactBean();
			     c1.setName(rs.getString(1));
			     c1.setNumber(rs.getInt(2));
			     c1.setGroup_info(rs.getString(3));
			     l1.add(c1);
		}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null ;
		
		
	}

	@Override
	public List <ContactBean>searchContact(String name) {
		List<ContactBean> list=new ArrayList<ContactBean>();
		try(Connection conn=(Connection) DriverManager.getConnection(prop.getProperty("dbUrl"));
				Statement stmt= (Statement) conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("searchquery")))
				
		{
			while(rs.next())
			{
				ContactBean c2=new ContactBean();
				c2.setName(rs.getString(1));
				list.add(c2);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addContact(ContactBean contact) {
		try (Connection conn=(Connection) DriverManager.getConnection(prop.getProperty("dbUrl"));
		PreparedStatement pstmt= conn.prepareStatement(prop.getProperty("insertQuery")))
	{
		   pstmt.setString(1, bean.getName());
		   pstmt.setInt(2, bean.getNumber());
		   pstmt.setString(3, bean.getGroup_info());
		   int count=pstmt.executeUpdate();
		   if(count>0)
		   {
			   return true;
		   }
		   
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false ;
	}

	@Override
	public boolean modifyContact(String name, ContactBean bean) {
		try(Connection conn=(Connection) DriverManager.getConnection(prop.getProperty("dbUrl"));
				PreparedStatement pstmt= conn.prepareStatement(prop.getProperty("upadateQuery")))
		{
			pstmt.setString(1, bean.getName());
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println("group info updated sucessfully");
			}
			else
			{
				System.out.println("something wrong");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteContact(int number) {
		try(Connection conn=(Connection) DriverManager.getConnection(prop.getProperty("dbUrl"));
				PreparedStatement pstmt= conn.prepareStatement(prop.getProperty("deleteQuery")))
		{
			pstmt.setInt(1,  number);
			int count=pstmt.executeUpdate();
			
			if(count>0)
			{
				System.out.println("record deleted sucessfully");
			}
			else
			{
				System.out.println("somethong wrong");
			}
			
		}
		catch(Exception e)
		{
			
		}
		
		return false;
	}

	

	
	

}
