package com.shoppingcart.models;

import java.util.List;

public class CategoryModel {

	private long categoryID;
	
	private String categoryName;
	
	List<ProductModel> productsInCategory;

	public CategoryModel() {
		super();
	}

	public CategoryModel(long categoryID, String categoryName, List<ProductModel> productsInCategory) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.productsInCategory = productsInCategory;
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

	public List<ProductModel> getProductsInCategory() {
		return productsInCategory;
	}

	public void setProductsInCategory(List<ProductModel> productsInCategory) {
		this.productsInCategory = productsInCategory;
	}
	
	
	
	
	
	
}
