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

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.AdminException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.UserException;
import com.capgemini.forestrymanagementsystembyusingjdbc.util.Utilty;

public class AdminDAOImpl implements AdminDAO {
	FileReader reader;
	Properties prop;
	UserBean admin;

	public AdminDAOImpl() {
		try {

			reader = new FileReader("admin.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public Connection getDatabaseConnection() throws AdminException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (AdminException | SQLException e) {
			throw new AdminException("Please Provid the Correct Connection Details");
		}
		return conn;
	}

	@Override
	public UserBean login(String username, String password, String role) throws LoginException {
		UserBean adminBean = null;
		try {
			adminBean = searchAdmin(username, role);
			if (adminBean != null) {
				return adminBean;
			} else {
				throw new LoginException("Sorry we can't find an account with the user name");
			}
		} catch (LoginException e) {
			throw new LoginException("Sorry we can't find an account with the user name");
		}

	}

	private UserBean searchAdmin(String username, String role) throws AdminException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchQuery"));
			pstmt.setString(1, username);
			pstmt.setString(2, role.toLowerCase());
			rs = pstmt.executeQuery();
			UserBean adminBean = null;
			while (rs.next()) {
				adminBean = new UserBean();
				adminBean.setUserName(rs.getString(1));
				adminBean.setPassword(rs.getString(2));
				adminBean.setRole(rs.getString(3));
			}
			return adminBean;
		} catch (AdminException | SQLException e) {
			// e.printStackTrace();
			throw new AdminException("Sorry we can't find an account with the user name");
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

	@Override
	public boolean addUser(UserBean userBean) throws UserException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String role = userBean.getRole();
		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));
			pstmt.setString(1, userBean.getUserName());
			pstmt.setString(2, userBean.getPassword());
			pstmt.setString(3, role.toLowerCase());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new UserException("User Name  Alreday Present,Please Give Another Name");
			}

		} catch (UserException | SQLException e) {
			throw new UserException("User Name  Alreday Present,Please Give Another Name");
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
	public boolean removeUser(String username, String role) throws UserException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			UserBean userBean = searchUser(username, role);
			if (userBean != null) {
				conn = getDatabaseConnection();
				pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"));
				pstmt.setString(1, username);
				pstmt.setString(2, role.toLowerCase());
				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new UserException("User Details Not Found To Delete");
				}
			} else {
				throw new UserException("User Details Not Found To Delete");
			}
		} catch (UserException | SQLException e) {
			throw new UserException("User Details Not Found To Delete");
		} finally {
			try {
				if (pstmt != null) {
					new Utilty().closePreStatement(pstmt);
				}
				if (conn != null) {
					new Utilty().closeConnection(conn);
				}

			} catch (SQLException e) {
				throw new UserException("User Details Not Found To Delete");
			}
		}

	}

	@Override
	public List<UserBean> showAllUser() throws UserException {
		List<UserBean> userList = new ArrayList<UserBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("selectQuery"));

			while (rs.next()) {
				UserBean userBean = new UserBean();
				userBean.setUserName(rs.getString(1));
				userBean.setPassword(rs.getString(2));
				userBean.setRole(rs.getString(3));
				userList.add(userBean);
			}
			return userList;
		} catch (UserException | SQLException e) {
			throw new UserException("User Details Not Present To View");
		} finally {
			try {
				if (stmt != null && conn != null && rs != null) {
					new Utilty().closeAll(conn, stmt, rs);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public UserBean searchUser(String username, String role) throws UserException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchQuery"));
			pstmt.setString(1, username);
			pstmt.setString(2, role.toLowerCase());
			rs = pstmt.executeQuery();
			UserBean userBean = null;
			while (rs.next()) {
				userBean = new UserBean();
				userBean.setUserName(rs.getString(1));
				userBean.setPassword(rs.getString(2));
				userBean.setRole(rs.getString(3));
			}
			return userBean;
		} catch (UserException | SQLException e) {
			throw new UserException("User Details Not Present To View For The Given Name");
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

	@Override
	public boolean modifyUser(UserBean userBean) throws UserException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String role = userBean.getRole();
		String username = userBean.getUserName();
		String password = userBean.getPassword();
		try {
			UserBean useBean = searchUser(username, role);
			if (useBean != null) {
				conn = getDatabaseConnection();
				pstmt = conn.prepareStatement(prop.getProperty("updateQuery"));

				pstmt.setString(1, password);
				pstmt.setString(2, role.toLowerCase());
				pstmt.setString(3, username);

				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new UserException("User Details Not Found To Delete");
				}
			} else {
				throw new UserException("User Details Not Found To Delete");
			}

		} catch (UserException | SQLException e) {
			throw new UserException("User Details Not Found To Delete");
		}
	}

}
