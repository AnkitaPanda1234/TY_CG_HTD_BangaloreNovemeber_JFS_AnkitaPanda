package com.cap.moduletest1.baen;

public class ProductBean {
	private int product_id;
	private String pdoductname;
	private double productcost;
	private String productcolor;
	private String description;
	private int numofproduct;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getPdoductname() {
		return pdoductname;
	}
	public void setPdoductname(String pdoductname) {
		this.pdoductname = pdoductname;
	}
	public double getProductcost() {
		return productcost;
	}
	public void setProductcost(double productcost) {
		this.productcost = productcost;
	}
	public String getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumofproduct() {
		return numofproduct;
	}
	public void setNumofproduct(int numofproduct) {
		this.numofproduct = numofproduct;
	}
	@Override
	public String toString() {
		return "ProductBean [product_id=" + product_id + ", pdoductname=" + pdoductname + ", productcost=" + productcost
				+ ", productcolor=" + productcolor + ", description=" + description + ", numofproduct=" + numofproduct
				+ ", getProduct_id()=" + getProduct_id() + ", getPdoductname()=" + getPdoductname()
				+ ", getProductcost()=" + getProductcost() + ", getProductcolor()=" + getProductcolor()
				+ ", getDescription()=" + getDescription() + ", getNumofproduct()=" + getNumofproduct()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
