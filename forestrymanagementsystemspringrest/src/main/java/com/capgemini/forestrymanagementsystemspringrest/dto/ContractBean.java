package com.capgemini.forestrymanagementsystemspringrest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contractor_info")
public class ContractBean {
	@Id
	@Column
	@GeneratedValue
	private int contractId;
	@Column
	private int orderId;
	@Column
	private int customerId;
	@Column
	private int productid;
	@Column
	private long quantity;
	@Column
	private String deliveryDate;

	@Column
	private String status;

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

	public int getProductId() {
		return productid;
	}

	public void setProductId(int productid) {
		this.productid = productid;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public long getQunatity() {
		return quantity;
	}

	public void setQunatity(long quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Contract Details : \n" + "ContractId=" + contractId + ", orderId=" + orderId + ", customerId="
				+ customerId + ", productid=" + productid + ", quantity=" + quantity + ", deliveryDate=" + deliveryDate
				+ ", status=" + status;
	}

}
