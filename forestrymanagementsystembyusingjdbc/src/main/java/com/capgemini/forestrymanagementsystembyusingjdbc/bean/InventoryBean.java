package com.capgemini.forestrymanagementsystembyusingjdbc.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InventoryBean implements Serializable {
	private int productId;
	private String productName;
	private long productQuantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product Details Are As Below: \n" + "Product Id=" + productId + ", Name=" + productName + ", Quantity="
				+ productQuantity;
	}

}
