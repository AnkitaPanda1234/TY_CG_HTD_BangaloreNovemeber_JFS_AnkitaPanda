package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.LandBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingjdbc.util.Utilty;

/**
 * 
 * @author Ankita Panda
 *
 */
public class LandDAOImpl implements LandDAO {
	FileReader reader;
	Properties prop;
	CustomerBean bean;

	SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");

	public LandDAOImpl() {
		try {
			reader = new FileReader("land.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getDatabaseConnection() throws LandException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (LandException | SQLException e) {
			throw new LandException("Please Provid the Correct Connection Details");
		}
		return conn;
	}

	@Override
	public boolean deleteLandDetails(int landid) throws LandException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"));
			pstmt.setInt(1, landid);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new LandException("Land Details Not Present To Delete For LandId :" + landid);
			}
		} catch (LandException | SQLException e) {
			throw new LandException("Land Details Not Present To Delete For LandId :" + landid);
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
	public boolean updateLandDeatails(int landid, long landvalue) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("updateQuery"));

			pstmt.setLong(1, landvalue);
			pstmt.setInt(2, landid);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new LandException("Land Details Not Present To Update");
			}
		} catch (SQLException e) {
			throw new LandException("Land Details Not Present To Update");
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
	public List<LandBean> showLandDetails() {
		List<LandBean> landList = new ArrayList<LandBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("query1"));

			while (rs.next()) {
				LandBean land = new LandBean();
				land.setLandid(rs.getInt(1));
				land.setLandLocation(rs.getString(2));
				land.setLandValue(rs.getInt(3));
				land.setRealisedDate(rs.getString(4));
				landList.add(land);
			}
			return landList;
		} catch (SQLException e) {
			throw new LandException("Land Details Not Present To View");
		}
		finally {
			try {
				if (stmt != null && conn != null && rs!=null ) {
					new Utilty().closeAll(conn, stmt, rs);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public LandBean viewLandDetails(int landid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("selectQuery"));
			pstmt.setInt(1, landid);
			rs = pstmt.executeQuery();
			LandBean land = null;
			while (rs.next()) {
				land = new LandBean();
				land.setLandid(rs.getInt(1));
				land.setLandLocation(rs.getString(2));
				land.setLandValue(rs.getInt(3));
				land.setRealisedDate(rs.getString(4));

			}
			return land;
		} catch (SQLException e) {
			throw new LandException("Land Details Not Present To View For LandId :" + landid);
		} finally {
			try {
				if (pstmt != null && conn != null && rs!=null ) {
					new Utilty().closeAll(conn, pstmt, rs);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public boolean addLandDetails(LandBean land) throws LandException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));

			String landInputDate = land.getRealisedDate();
			// Date inputDate=Date.valueOf(date);

			java.util.Date date = sdfrmt.parse(landInputDate);
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

			pstmt.setInt(1, land.getLandid());
			pstmt.setString(2, land.getLandLocation());
			pstmt.setLong(3, land.getLandValue());
			pstmt.setDate(4, sqlStartDate);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new LandException("Land Details Alreday Present");
			}
		} catch (SQLException | ParseException e) {
			throw new LandException("Land Details Alreday Present");
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

}
