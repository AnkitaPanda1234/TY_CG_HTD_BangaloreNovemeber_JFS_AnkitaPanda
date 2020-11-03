package com.capgemini.forestrymanagementsystemspringrest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule_info")
public class ScheduleBean {
	@Id
	@Column
	@GeneratedValue
	private int scheduleId;
	@Column
	private int contractId;
	@Column
	private int customerId;
	@Column
	private int productId;
	@Column
	private long quantity;
	@Column
	private int orderId;
	@Column
	private String deliveryDate;
	@Column
	private String status;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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


	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Schedule Details :\n"
				+ " ScheduleId=" + scheduleId + ", ContractId=" + contractId + ", Customer Id=" + customerId
				+ ", ProductId=" + productId + ", Quantity=" + quantity + ", OrderId=" + orderId + ", DeliveryDate="
				+ deliveryDate + ", Status=" + status + "]";
	}

}
