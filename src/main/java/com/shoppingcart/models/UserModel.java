package com.shoppingcart.models;

public class UserModel {
	
	private long userID;
	
	private OrderModel myOrder;
	
	private ItemModel itemModel;

	public UserModel() {
		super();
	}

	public UserModel(long userID, OrderModel myOrder, ItemModel itemModel) {
		super();
		this.userID = userID;
		this.myOrder = myOrder;
		this.itemModel = itemModel;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public OrderModel getMyOrder() {
		return myOrder;
	}

	public void setMyOrder(OrderModel myOrder) {
		this.myOrder = myOrder;
	}

	public ItemModel getItemModel() {
		return itemModel;
	}

	public void setItemModel(ItemModel itemModel) {
		this.itemModel = itemModel;
	}
	
	

}
