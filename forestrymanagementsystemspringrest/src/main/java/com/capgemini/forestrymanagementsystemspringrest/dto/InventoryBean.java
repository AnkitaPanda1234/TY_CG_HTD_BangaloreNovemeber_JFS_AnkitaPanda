package com.capgemini.forestrymanagementsystemspringrest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "product_info")
public class InventoryBean implements Serializable {
	@Id
	@Column
	@GeneratedValue
	private int productid;
	@Column
	private String productname;
	@Column
	private long productquantity;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public long getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(long productquantity) {
		this.productquantity = productquantity;
	}

	@Override
	public String toString() {
		return "InventoryBean [productid=" + productid + ", productname=" + productname + ", productquantity="
				+ productquantity + "]";
	}

}
