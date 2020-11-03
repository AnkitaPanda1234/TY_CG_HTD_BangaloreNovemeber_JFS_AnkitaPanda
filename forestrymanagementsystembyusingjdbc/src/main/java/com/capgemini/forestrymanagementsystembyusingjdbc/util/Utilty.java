/**
 * 
 */
package com.capgemini.forestrymanagementsystembyusingjdbc.util;

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

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ClientBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.AdminException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.UserException;

/**
 * @author Ankita Panda
 *
 */
public class Utilty {
	FileReader reader;
	static Properties prop;
	UserBean admin;
	static List<UserBean> adminList = new ArrayList<UserBean>();
	static List<ClientBean> clientList = new ArrayList<ClientBean>();
	static List<SchedulerBean> schedulerList = new ArrayList<SchedulerBean>();

	public Utilty() {
		try {
			reader = new FileReader("client.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static Connection getDatabaseConnection() throws UserException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (UserException | SQLException e) {
			throw new UserException("Please Provid the Correct Connection Details");
		}
		return conn;
	}

	public List<ClientBean> loadAllCient() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("selectAllClient"));
			while (rs.next()) {
				ClientBean clientBean = new ClientBean();
				clientBean.setUserName(rs.getString(1));
				clientBean.setPassword(rs.getString(2));
				clientBean.setRole(rs.getString(3));
				clientList.add(clientBean);
			}
			return clientList;
		} catch (UserException | SQLException e) {
			// e.printStackTrace();
			throw new UserException("Sorry we can't find any clinet account");
		}
	}

	public List<UserBean> loadAllAdmin() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("selectAllAdmin"));
			while (rs.next()) {
				UserBean adminBean = new UserBean();
				adminBean.setUserName(rs.getString(1));
				adminBean.setPassword(rs.getString(2));
				adminBean.setRole(rs.getString(3));
				adminList.add(adminBean);
			}
			return adminList;
		} catch (AdminException | SQLException e) {
			throw new AdminException("Sorry we can't find any admin account");
		}
	}

	public List<SchedulerBean> loadAllScheduler() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("selectAllScheduler"));
			while (rs.next()) {
				SchedulerBean schedulerBean = new SchedulerBean();
				schedulerBean.setUserName(rs.getString(1));
				schedulerBean.setPassword(rs.getString(2));
				schedulerBean.setRole(rs.getString(3));
				schedulerList.add(schedulerBean);
			}
			return schedulerList;
		} catch (SchedulerException | SQLException e) {
			throw new SchedulerException("Sorry we can't find any scheduler account");
		}
	}

	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				/* ignored */}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				/* ignored */}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				/* ignored */}
		}
	}

	public void closeAll(Connection conn, Statement st, ResultSet rs) throws SQLException {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				/* ignored */}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				/* ignored */}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				/* ignored */}
		}
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public void closeStatement(Statement st) throws SQLException {
		st.close();
	}

	public void closePreStatement(PreparedStatement pst) throws SQLException {
		pst.close();
	}

	public void closeResultSet(ResultSet rs) throws SQLException {
		rs.close();
	}

}
