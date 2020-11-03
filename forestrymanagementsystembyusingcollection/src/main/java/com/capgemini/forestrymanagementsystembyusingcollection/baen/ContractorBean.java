package com.capgemini.forestrymanagementsystembyusingcollection.baen;

public class ContractorBean {

	private int contractNo;
	private int orderId;
	private int customerId;
	private int productId;
	private long qunatity;
	private int haulierId;
	private String deliveryDate;
	private String status;
	public int getContractNo() {
		return contractNo;
	}
	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
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
	public long getQunatity() {
		return qunatity;
	}
	public void setQunatity(long qunatity) {
		this.qunatity = qunatity;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ContractorBean [contractNo=" + contractNo + ", orderId=" + orderId + ", customerId=" + customerId
				+ ", productId=" + productId + ", qunatity=" + qunatity + ", haulierId=" + haulierId + ", deliveryDate="
				+ deliveryDate + ", status=" + status + "]";
	}

	

}
