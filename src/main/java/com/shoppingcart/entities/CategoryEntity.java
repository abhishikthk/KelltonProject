package com.shoppingcart.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class CategoryEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryID;
	
	private String categoryName;
	
	@OneToMany
	@JoinTable(name="Category_Product",joinColumns = @JoinColumn(name = "categoryID"),inverseJoinColumns = @JoinColumn(name="productID"))
	List<ProductEntity> categoryProduct;

	public CategoryEntity() {
		super();
	}

	public CategoryEntity(long categoryID, String categoryName, List<ProductEntity> categoryProduct) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.categoryProduct = categoryProduct;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductEntity> getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(List<ProductEntity> categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	
	

	
}
