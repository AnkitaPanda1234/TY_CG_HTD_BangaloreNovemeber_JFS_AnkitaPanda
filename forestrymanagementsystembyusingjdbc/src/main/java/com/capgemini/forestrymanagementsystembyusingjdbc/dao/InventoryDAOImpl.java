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

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingjdbc.util.Utilty;

/**
 * 
 * @author Ankita Panda
 *
 */
public class InventoryDAOImpl implements InventoryDAO {
	FileReader reader;
	Properties prop;
	InventoryBean bean;

	/**
	 * Default Constructor
	 */
	public InventoryDAOImpl() {
		try {
			reader = new FileReader("product.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertProduct(InventoryBean prod) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getDatabaseConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));
			}
			pstmt.setInt(1, prod.getProductId());
			pstmt.setString(2, prod.getProductName());
			pstmt.setLong(3, prod.getProductQuantity());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new ProductException("Product Details Already Present");
			}

		} catch (SQLException e) {
			throw new ProductException("Product Details Already Present");
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
	public boolean deleteProduct(int productId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			InventoryBean bean = searchProduct(productId);
			if (bean != null) {
				conn = getDatabaseConnection();
				if (conn != null) {
					pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"));
				}

				pstmt.setInt(1, productId);
				pstmt.executeUpdate();
				return true;
			} else {
				System.out.println("Product Details Not Exists ");
				return false;
			}

		} catch (SQLException e) {
			throw new ProductException("Product Details Not Present To Delete For Product Id :" + productId);

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
	public boolean modifyProduct(int productId, String productDetails, String query) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			InventoryBean bean = searchProduct(productId);
			if (bean != null) {
				conn = getDatabaseConnection();
				if (conn != null) {
					pstmt = conn.prepareStatement(prop.getProperty(query));
				}
				if (pstmt != null) {
					pstmt.setString(1, productDetails);
					pstmt.setInt(2, productId);
				}
				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				} else {
					throw new ProductException("Product Details Not Present To Update");
				}
			} else {
				throw new ProductException("Product Details Not Present To Update");
			}

		} catch (SQLException e) {
			throw new ProductException("Product Details Not Present To Update");
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
	public List<InventoryBean> getAllProduct() {
		List<InventoryBean> list = new ArrayList<InventoryBean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(prop.getProperty("query1"));
			}
			while (rs.next()) {
				bean = new InventoryBean();
				bean.setProductId(rs.getInt(1));
				bean.setProductName(rs.getString(2));
				bean.setProductQuantity(rs.getLong(3));
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			throw new ProductException("Product Details Not Present");
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
	public InventoryBean searchProduct(int productid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getDatabaseConnection();
			pstmt = conn.prepareStatement(prop.getProperty("searchQuery"));
			pstmt.setInt(1, productid);
			rs = pstmt.executeQuery();
			InventoryBean productBean = null;
			while (rs.next()) {
				productBean = new InventoryBean();
				productBean.setProductId(rs.getInt(1));
				productBean.setProductName(rs.getString(2));
				productBean.setProductQuantity(rs.getLong(3));
			}
			return productBean;
		} catch (SQLException e) {
			throw new ProductException("Product Details Not Present To View For Product Id :" + productid);
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

	public Connection getDatabaseConnection() throws ProductException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
		} catch (SQLException e) {
			throw new ProductException("Please Provid the Correct Connection Details");
		}
		return conn;
	}
}
