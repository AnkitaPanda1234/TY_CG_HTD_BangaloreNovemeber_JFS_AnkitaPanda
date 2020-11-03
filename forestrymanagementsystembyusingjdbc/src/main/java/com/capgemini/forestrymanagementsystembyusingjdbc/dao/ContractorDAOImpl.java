package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
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

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingjdbc.util.Utilty;

public class ContractorDAOImpl implements ContractorDAO {
	FileReader reader;
	Properties prop;
	SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy"); // new SimpleDateFormat("yyyy-MM-dd");

	public ContractorDAOImpl() {
		try {

			reader = new FileReader("contractor.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public Connection getDatabaseConnection() throws ContractException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (ContractException | SQLException e) {
			throw new LandException("Please Provid the Correct Connection Details");
		}
		return conn;
	}

	@Override
	public boolean addContract(ContractorBean bean) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			ContractorBean contractorBean = viewContract(bean.getContractNo());
			if (contractorBean != null) {// && contractorBean.getStatus().equalsIgnoreCase("Ordered")) {
				throw new ContractException("Contract Details Alreday Present");
			} else {
				conn = getDatabaseConnection();
				pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));
				String orderDate = bean.getDeliveryDate();
				java.util.Date date = sdfrmt.parse(orderDate);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

				pstmt.setInt(1, bean.getContractNo());
				pstmt.setInt(2, bean.getorderId());
				pstmt.setInt(3, bean.getCustomerId());
				pstmt.setInt(4, bean.getProductId());
				pstmt.setLong(5, bean.getQunatity());
				pstmt.setInt(6, bean.getHaulierId());
				pstmt.setDate(7, sqlStartDate);
				pstmt.setString(8, bean.getStatus());

				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new ContractException("Contract Details Alreday Present");
				}
			}
		} catch (ContractException | SQLException | ParseException e) {
			// e.printStackTrace();
			throw new ContractException("Contract Details Alreday Present");
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
	public boolean deleteContract(int contractId, int orderId) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"));

			pstmt.setString(1, "Cancelled");
			pstmt.setInt(2, contractId);
			pstmt.setInt(3, orderId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new ContractException(
						"Contract Details Not Present  For Contract :" + contractId + "Order Id: " + orderId);
			}
		} catch (ContractException | SQLException e) {
			throw new ContractException(
					"Contract Details Not Present  For Contract :" + contractId + "Order Id: " + orderId);
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
	public List<ContractorBean> getAllContract() throws ContractException {
		List<ContractorBean> list = new ArrayList<ContractorBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("getAllContractQuery"));
			while (rs.next()) {
				ContractorBean contractorBean = new ContractorBean();
				contractorBean.setContractNo(rs.getInt(1));
				contractorBean.setorderId(rs.getInt(2));
				contractorBean.setCustomerId(rs.getInt(3));
				contractorBean.setProductId(rs.getInt(4));
				contractorBean.setQunatity(rs.getInt(5));
				contractorBean.setHaulierId(rs.getInt(6));
				contractorBean.setDeliveryDate(rs.getString(7));
				contractorBean.setStatus(rs.getString(8));
				list.add(contractorBean);
			}
			return list;

		} catch (ContractException | SQLException e) {
			throw new ContractException("Contract Details Not Present To View");
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
	public ContractorBean viewContract(int contractId) throws ContractException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchQuery"));
			pstmt.setInt(1, contractId);
			rs = pstmt.executeQuery();
			ContractorBean contractorBean = null;
			while (rs.next()) {
				contractorBean = new ContractorBean();
				contractorBean.setContractNo(rs.getInt(1));
				contractorBean.setorderId(rs.getInt(2));
				contractorBean.setCustomerId(rs.getInt(3));
				contractorBean.setProductId(rs.getInt(4));
				contractorBean.setQunatity(rs.getInt(5));
				contractorBean.setHaulierId(rs.getInt(6));
				contractorBean.setDeliveryDate(rs.getString(7));
				contractorBean.setStatus(rs.getString(8));
			}
			return contractorBean;
		} catch (ContractException | SQLException e) {
			throw new ContractException("Contract Details Not Present To View");
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

	public ContractorBean viewOrderPerContract(int contractId, int orderId) throws ContractException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("selectOrder"));

			pstmt.setInt(1, contractId);
			pstmt.setInt(2, orderId);
			rs = pstmt.executeQuery();

			ContractorBean contractorBean = null;

			while (rs.next()) {
				contractorBean = new ContractorBean();
				contractorBean.setContractNo(contractId);
				contractorBean.setorderId(orderId);
				contractorBean.setCustomerId(rs.getInt(3));
				contractorBean.setProductId(rs.getInt(4));
				contractorBean.setQunatity(rs.getInt(5));
				contractorBean.setHaulierId(rs.getInt(6));
				contractorBean.setDeliveryDate(rs.getString(7));

			}
			return contractorBean;
		} catch (ContractException | SQLException e) {
			throw new ContractException("Contract Details Not Present To View");
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
	public List<ContractorBean> getAllContractPerDate(Date schdeuleDate) throws ContractException {
		List<ContractorBean> list = new ArrayList<ContractorBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("searchPerDateQuery"));
			while (rs.next()) {
				ContractorBean contractorBean = new ContractorBean();
				contractorBean.setContractNo(rs.getInt(1));
				contractorBean.setorderId(rs.getInt(2));
				contractorBean.setCustomerId(rs.getInt(3));
				contractorBean.setProductId(rs.getInt(4));
				contractorBean.setQunatity(rs.getInt(5));
				contractorBean.setHaulierId(rs.getInt(3));
				contractorBean.setDeliveryDate(rs.getString(4));
				list.add(contractorBean);
			}
			return list;

		} catch (ContractException | SQLException e) {
			throw new ContractException("Contract Details Not Present To View");
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
