package com.shoppingcart.entities;


import javax.persistence.*;

@Entity
public class ProductEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long productID;

	@ManyToOne
	private CategoryEntity categoryEntity;

	private String type;
	
	private String name;
	private double price;
	private String description;

	
	public ProductEntity() {
		super();
	}

	public ProductEntity(long productID, CategoryEntity categoryEntity, String name, double price, String description, String type) {
		super();
		this.productID = productID;
		this.categoryEntity = categoryEntity;
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


	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
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
