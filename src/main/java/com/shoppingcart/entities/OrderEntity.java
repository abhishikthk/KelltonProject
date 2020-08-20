package com.shoppingcart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemID;

	@ManyToMany(mappedBy = "myOrder")
	List<UserEntity> userEntity;
	
	@ManyToOne
	private CategoryEntity categoryEntity;

	private long productID;
	private String type;
	private String name;
	private double price;
	private String description;
	private long userID;
	
	public OrderEntity() {
		super();
	}
	
	public OrderEntity(long itemID, List<UserEntity> userEntity, CategoryEntity categoryEntity, long productID,
			String type, String name, double price, String description, long userID) {
		super();
		this.itemID = itemID;
		this.userEntity = userEntity;
		this.categoryEntity = categoryEntity;
		this.productID = productID;
		this.type = type;
		this.name = name;
		this.price = price;
		this.description = description;
		this.userID = userID;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public List<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(List<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
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

