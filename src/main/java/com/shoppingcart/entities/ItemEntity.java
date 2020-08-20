package com.shoppingcart.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemID;

	@ManyToMany(mappedBy = "myItem")
	List<UserEntity> userEntity;
	
	@ManyToOne
	private CategoryEntity categoryEntity;

	private long productID;
	private String type;
	private String name;
	private double price;
	private String description;
	private long userID;
	
	public ItemEntity() {
		super();
	}

	public ItemEntity(long itemID, List<UserEntity> userEntity, CategoryEntity categoryEntity, long productID,
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

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
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
