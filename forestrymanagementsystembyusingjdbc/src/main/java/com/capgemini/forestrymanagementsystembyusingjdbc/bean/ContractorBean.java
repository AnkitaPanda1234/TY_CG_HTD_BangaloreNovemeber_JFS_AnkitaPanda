package com.capgemini.forestrymanagementsystembyusingjdbc.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContractorBean implements Serializable {

	private int contractNo;
	private int orderId;
	private int customerId;
	private int productId;
	private long qunatity;
	private int haulierId;
	private String deliveryDate;
	private String status;

	public int getorderId() {
		return orderId;
	}

	public void setorderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getHaulierId() {
		return haulierId;
	}

	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the qunatity
	 */
	public long getQunatity() {
		return qunatity;
	}

	/**
	 * @param qunatity
	 *            the qunatity to set
	 */
	public void setQunatity(long qunatity) {
		this.qunatity = qunatity;
	}

	/**
	 * @return the contractNo
	 */
	public int getContractNo() {
		return contractNo;
	}

	/**
	 * @param contractNo
	 *            the contractNo to set
	 */
	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Contractor Deatils : \n"
				+ " Contract No=" + contractNo + ", OrderId=" + orderId + ", CustomerId=" + customerId
				+ " \n , ProductId=" + productId + ", Qunatity=" + qunatity + ", HaulierId=" + haulierId 
				+ ", DeliveryDate="
				+ deliveryDate + ", Order Status=" + status + "]";
	}

}
