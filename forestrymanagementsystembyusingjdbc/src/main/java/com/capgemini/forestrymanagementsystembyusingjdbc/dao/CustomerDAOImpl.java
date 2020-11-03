package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.util.Utilty;

public class CustomerDAOImpl implements CustomerDAO {
	FileReader reader;
	Properties prop;
	CustomerBean bean;

	public CustomerDAOImpl() {
		try {

			reader = new FileReader("customer.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public Connection getDatabaseConnection() throws CustomerException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (SQLException e) {
			throw new CustomerException("Please Provid the Correct Connection Details");
		}
		return conn;
	}

	@Override
	public boolean addCustomer(CustomerBean bean) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));

			pstmt.setInt(1, bean.getCustomerid());
			pstmt.setString(2, bean.getCustomerName());
			pstmt.setString(3, bean.getTown());
			pstmt.setString(4, bean.getStreetAddress1());
			pstmt.setString(5, bean.getStreetAddress2());
			pstmt.setInt(6, bean.getPostalCode());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getTelephoneNum());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new CustomerException("Customer Details Alreday Present");
			}

		} catch (SQLException e) {
			throw new CustomerException("Customer Details Alreday Present");
		} finally {
			try {
				if (pstmt != null) {
					new Utilty().closePreStatement(pstmt);
				}
				if (conn != null) {
					new Utilty().closeConnection(conn);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public boolean deleteCustomer(int customerid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			CustomerBean customerBean = viewCustomer(customerid);
			if (customerBean != null) {
				conn = getDatabaseConnection();
				pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"));
				pstmt.setInt(1, customerid);
				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new CustomerException("Customer Details Not Present To Delete");
				}
			} else {
				throw new CustomerException("Customer Details Not Present To Delete");
			}
		} catch (SQLException e) {
			throw new CustomerException("Customer Details Not Present To Delete");
		} finally {
			try {
				if (pstmt != null) {
					new Utilty().closePreStatement(pstmt);
				}
				if (conn != null) {
					new Utilty().closeConnection(conn);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public boolean modifyCustomer(int customerid, CustomerBean bean) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			CustomerBean customerBean = viewCustomer(customerid);
			if (customerBean != null) {
				conn = getDatabaseConnection();
				pstmt = conn.prepareStatement(prop.getProperty("updateQuery"));
				pstmt.setString(1, bean.getCustomerName());
				pstmt.setString(2, bean.getTown());
				pstmt.setString(3, bean.getStreetAddress1());
				pstmt.setString(4, bean.getStreetAddress2());
				pstmt.setInt(5, bean.getPostalCode());
				pstmt.setString(6, bean.getEmail());
				pstmt.setLong(7, bean.getTelephoneNum());
				pstmt.setInt(8, customerid);
				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new CustomerException("Customer Details Not Present To Update");
				}

			} else {
				throw new CustomerException("Customer Details Not Present To Update");
			}

		} catch (SQLException e) {
			throw new CustomerException("Customer Details Not Present To Update");
		} finally {
			try {
				if (pstmt != null) {
					new Utilty().closePreStatement(pstmt);
				}
				if (conn != null) {
					new Utilty().closeConnection(conn);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("selectQuery"))) {
			while (rs.next()) {
				bean = new CustomerBean();
				bean.setCustomerid(rs.getInt(1));
				bean.setCustomerName(rs.getString(2));
				bean.setTown(rs.getString(3));
				bean.setStreetAddress1(rs.getString(4));
				bean.setStreetAddress2(rs.getString(5));
				bean.setPostalCode(rs.getInt(6));
				bean.setEmail(rs.getString(7));
				bean.setTelephoneNum(rs.getLong(8));
				list.add(bean);
			}
			return list;

		} catch (SQLException e) {
			throw new CustomerException("Customer Details Not Present ");
		}
	}

	@Override
	public CustomerBean viewCustomer(int customerid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchQuery"));
			pstmt.setInt(1, customerid);
			rs = pstmt.executeQuery();
			CustomerBean customerBean = null;
			while (rs.next()) {
				customerBean = new CustomerBean();
				customerBean.setCustomerid(rs.getInt(1));
				customerBean.setCustomerName(rs.getString(2));
				customerBean.setTown(rs.getString(3));
				customerBean.setStreetAddress1(rs.getString(4));
				customerBean.setStreetAddress2(rs.getString(5));
				customerBean.setPostalCode(rs.getInt(6));
				customerBean.setEmail(rs.getString(7));
				customerBean.setTelephoneNum(rs.getLong(8));

			}
			return customerBean;
		} catch (SQLException e) {
			throw new CustomerException("Customer Details Not Present");
		} finally {
			try {
				if (pstmt != null && conn != null && rs != null) {
					new Utilty().closeAll(conn, pstmt, rs);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
