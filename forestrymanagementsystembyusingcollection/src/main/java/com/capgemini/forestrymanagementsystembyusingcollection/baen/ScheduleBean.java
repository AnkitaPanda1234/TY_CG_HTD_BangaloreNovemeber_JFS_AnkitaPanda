package com.capgemini.forestrymanagementsystembyusingcollection.baen;

public class ScheduleBean {
	private int schedulerId;
	private int customerid;
	private int productId;
	private int contractId;
	private int orderId;
	private String deliveryDate;
	private String status;

	public int getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(int schedulerId) {
		this.schedulerId = schedulerId;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
		return "ScheduleBean [schedulerId=" + schedulerId + ", customerid=" + customerid + ", productId=" + productId
				+ ", contractId=" + contractId + ", orderId=" + orderId + ", deliveryDate=" + deliveryDate + ", status="
				+ status + "]";
	}

}
