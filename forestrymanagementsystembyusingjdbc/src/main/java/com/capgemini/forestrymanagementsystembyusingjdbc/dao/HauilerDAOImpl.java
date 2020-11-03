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
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.HauilerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.util.Utilty;

public class HauilerDAOImpl implements HauilerDAO {

	FileReader reader;
	Properties prop;
	CustomerBean bean;

	public HauilerDAOImpl() {
		try {

			reader = new FileReader("haulier.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public Connection getDatabaseConnection() throws HauilerException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (SQLException e) {
			throw new HauilerException("Please Provid the Correct Connection Details");
		}
		return conn;
	}

	@Override
	public boolean addHauiler(HauilerBean bean) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));

			pstmt.setInt(1, bean.getHauilerid());
			pstmt.setString(2, bean.getHauilername());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getStreetAddress1());
			pstmt.setString(5, bean.getStreetAddress2());
			pstmt.setString(6, bean.getTown());
			pstmt.setInt(7, bean.getPostalCode());
			pstmt.setLong(8, bean.getContactnum());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new HauilerException("Hauiler Details Alreday Present");
			}
		} catch (SQLException e) {
			throw new HauilerException("Hauiler Details Alreday Present");
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
	public boolean deleteHauiler(int hauilerid) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			HauilerBean hauilerBean = searchHauiler(hauilerid);
			if (hauilerBean != null) {
				conn = getDatabaseConnection();
				pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"));
				pstmt.setInt(1, hauilerid);
				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new HauilerException("Hauiler Details Not Present The Given Hauiler Id");
				}
			} else {
				throw new HauilerException("Hauiler Details Not Present The Given Hauiler Id");
			}

		} catch (SQLException e) {
			throw new HauilerException("Hauiler Details Not Present The Given Hauiler Id");
		}

	}

	@Override
	public boolean modifyHauiler(int hauilerid, HauilerBean bean) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			HauilerBean hauilerBean = searchHauiler(hauilerid);
			if (hauilerBean != null) {
				conn = getDatabaseConnection();
				pstmt = conn.prepareStatement(prop.getProperty("updateQuery"));
				pstmt.setString(1, bean.getHauilername());
				pstmt.setString(2, bean.getEmail());
				pstmt.setString(3, bean.getStreetAddress1());
				pstmt.setString(4, bean.getStreetAddress2());
				pstmt.setString(5, bean.getTown());
				pstmt.setInt(6, bean.getPostalCode());
				pstmt.setLong(7, bean.getContactnum());
				pstmt.setInt(8, hauilerid);
				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new HauilerException("Hauiler Details Not Present The Given Hauiler Id");
				}
			} else {
				throw new HauilerException("Hauiler Details Not Present The Given Hauiler Id");
			}
		} catch (SQLException e) {
			throw new HauilerException("Hauiler Details Not Present The Given Hauiler Id");
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
	public HauilerBean searchHauiler(int hauilerid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchQuery"));

			pstmt.setInt(1, hauilerid);
			rs = pstmt.executeQuery();

			HauilerBean hauilerBean = null;
			while (rs.next()) {
				hauilerBean = new HauilerBean();
				hauilerBean.setHauilerid(rs.getInt(1));
				hauilerBean.setHauilername(rs.getString(2));
				hauilerBean.setEmail(rs.getString(3));
				hauilerBean.setStreetAddress1(rs.getString(4));
				hauilerBean.setStreetAddress2(rs.getString(5));
				hauilerBean.setTown(rs.getString(6));
				hauilerBean.setPostalCode(rs.getInt(7));
				hauilerBean.setContactnum(rs.getLong(8));
			}
			return hauilerBean;
		} catch (SQLException e) {
			throw new HauilerException("Hauiler Details Not Present The Given Hauiler Id");
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
	public List<HauilerBean> getHauiler() {

		List<HauilerBean> list = new ArrayList<HauilerBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("query1"));
			while (rs.next()) {
				HauilerBean hauilerBean = new HauilerBean();
				hauilerBean.setHauilerid(rs.getInt(1));
				hauilerBean.setHauilername(rs.getString(2));
				hauilerBean.setEmail(rs.getString(3));
				hauilerBean.setStreetAddress1(rs.getString(4));
				hauilerBean.setStreetAddress2(rs.getString(5));
				hauilerBean.setTown(rs.getString(6));
				hauilerBean.setPostalCode(rs.getInt(7));
				hauilerBean.setContactnum(rs.getInt(8));
				list.add(hauilerBean);
			}
			return list;
		} catch (SQLException e) {
			throw new HauilerException("Hauiler Details Not Present");
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

}
