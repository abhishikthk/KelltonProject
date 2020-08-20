package com.shoppingcart.models;

public class ProductModel {

	private long productID;
	private String category;
	private String type;
	private String name;
	private double price;
	private String description;
	
	public ProductModel() {
		super();
	}

	public ProductModel(long productID, String category, String name, double price, String description, String type) {
		super();
		this.productID = productID;
		this.category = category;
		this.name = name;
		this.price = price;
		this.description = description;
		this.type = type;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
