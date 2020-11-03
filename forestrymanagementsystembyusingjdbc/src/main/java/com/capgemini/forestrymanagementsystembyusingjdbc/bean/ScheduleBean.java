package com.capgemini.forestrymanagementsystembyusingjdbc.bean;

public class ScheduleBean {

	private int scheduleId;
	private int customerId;
	private int contractId;
	private int productId;
	private long qunatity;
	private int orderId;
	private String deliveryDate;
	private String status;

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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getQunatity() {
		return qunatity;
	}

	public void setQunatity(long qunatity) {
		this.qunatity = qunatity;
	}

	@Override
	public String toString() {
		return "Schedule Details :\n"
				+ "Schedule Id=" + scheduleId + ", Customer Id=" + customerId + ", Contract Id=" + contractId
				+ "Product Id=" + productId + ", Qunatity=" + qunatity + ", Order Id=" + orderId + ", DeliveryDate="
				+ deliveryDate + ", Status=" + status ;
	}



}
