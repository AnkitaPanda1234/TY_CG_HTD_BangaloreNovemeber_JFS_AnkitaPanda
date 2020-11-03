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
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.util.Utilty;

public class ScheduleDAOImpl implements ScheduleDAO {

	FileReader reader;
	Properties prop;
	SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");

	public ScheduleDAOImpl() {
		try {

			reader = new FileReader("schedule.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public Connection getDatabaseConnection() throws SchedulerException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (SchedulerException | SQLException e) {
			throw new SchedulerException("Please Provid the Correct Connection Details");
		}
		return conn;
	}

	@Override
	public boolean addSchedule(ScheduleBean schedule) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));

			String deliveryDate = schedule.getDeliveryDate();

			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(deliveryDate);

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pstmt.setInt(1, schedule.getScheduleId());
			pstmt.setInt(2, schedule.getCustomerId());
			pstmt.setInt(3, schedule.getContractId());
			pstmt.setInt(4, schedule.getProductId());
			pstmt.setInt(5, schedule.getOrderId());
			pstmt.setDate(6, sqlDate);
			pstmt.setString(7, schedule.getStatus());
			pstmt.setLong(8, schedule.getQunatity());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new SchedulerException("Scheduler Details Alreday Present");
			}
		} catch (SchedulerException | SQLException | ParseException e) {
			throw new SchedulerException("Scheduler Details Alreday Present");
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
	public ScheduleBean searchSchedule(int schedulerid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchQuery"));
			pstmt.setInt(1, schedulerid);
			rs = pstmt.executeQuery();
			ScheduleBean scheduleBean = null;
			while (rs.next()) {
				scheduleBean = new ScheduleBean();
				scheduleBean.setScheduleId(rs.getInt(1));
				scheduleBean.setContractId(rs.getInt(2));
				scheduleBean.setCustomerId(rs.getInt(3));
				scheduleBean.setOrderId(rs.getInt(4));
				scheduleBean.setProductId(rs.getInt(5));
				scheduleBean.setDeliveryDate(rs.getString(6));
				scheduleBean.setStatus(rs.getString(7));
				scheduleBean.setQunatity(rs.getLong(8));
			}
			return scheduleBean;
		} catch (SchedulerException | SQLException e) {
			throw new SchedulerException("Schedule Details Not Present To View");
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
	public List<ScheduleBean> getAllSchedule() {
		List<ScheduleBean> list = new ArrayList<ScheduleBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("getAllScgeduleQuery"));
			while (rs.next()) {
				ScheduleBean scheduleBean = new ScheduleBean();
				scheduleBean.setScheduleId(rs.getInt(1));
				scheduleBean.setContractId(rs.getInt(2));
				scheduleBean.setCustomerId(rs.getInt(3));
				scheduleBean.setOrderId(rs.getInt(4));
				scheduleBean.setProductId(rs.getInt(5));
				scheduleBean.setDeliveryDate(rs.getString(6));
				list.add(scheduleBean);
			}
			return list;

		} catch (SchedulerException | SQLException e) {
			throw new SchedulerException("Schedule Details Not Present To View");
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
	public boolean updateSchedule(int contractId, String status) throws SchedulerException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int scheduleId = 0;
		try {
			scheduleId = searchScheduleByContractId(contractId);
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("updateQuery"));

			pstmt.setString(1, status);
			pstmt.setInt(2, scheduleId);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new SchedulerException("Scheduler Details Not Present To Update");
			}
		} catch (SQLException e) {
			throw new SchedulerException("Scheduler Details Not Present To Update");
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

	public int searchScheduleByContractId(int contractId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int scheduleId = 0;
		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchByContractIdQuery"));
			pstmt.setInt(1, contractId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				scheduleId = rs.getInt(1);
			}
			return scheduleId;
		} catch (SchedulerException | SQLException e) {
			throw new SchedulerException("Schedule Details Not Present To View");
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
	public boolean cancelSchedule(int schduleNo) throws SchedulerException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ScheduleBean scheduleBean = null;
		try {

		//	scheduleBean = searchSchedule(schduleNo);

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("updateQuery"));

			pstmt.setString(1, "Cancelled");
			pstmt.setInt(2, schduleNo);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new LandException("Scheduled Details Cancelled ");
			}
		} catch (SQLException e) {
			throw new LandException("Scheduled Details Not Present To Cancel");
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
