package com.shoppingcart.models;

public class ItemModel {
	
	private long productID;
	private String category;
	private String type;
	private String name;
	private double price;
	private String description;
	private long userID;
	
	public ItemModel() {
		super();
	}

	

	public ItemModel(long productID, String category, String type, String name, double price, String description,
			long userID) {
		super();
		this.productID = productID;
		this.category = category;
		this.type = type;
		this.name = name;
		this.price = price;
		this.description = description;
		this.userID = userID;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	
	

}
