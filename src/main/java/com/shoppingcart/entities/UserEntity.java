package com.shoppingcart.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class UserEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long userID;

	@ManyToMany
	@JoinTable(name="User_Order",joinColumns = @JoinColumn(name = "userID"),inverseJoinColumns = @JoinColumn(name="orderID"))
	List<OrderEntity> myOrder;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="User_Item",joinColumns = @JoinColumn(name = "userID"),inverseJoinColumns = @JoinColumn(name="itemID"))
	List<ItemEntity> myItem;

	public UserEntity() {
		super();
	}

	public UserEntity(long userID, List<OrderEntity> myOrder, List<ItemEntity> myItem) {
		super();
		this.userID = userID;
		this.myOrder = myOrder;
		this.myItem = myItem;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public List<OrderEntity> getMyOrder() {
		return myOrder;
	}

	public void setMyOrder(List<OrderEntity> myOrder) {
		this.myOrder = myOrder;
	}

	public List<ItemEntity> getMyItem() {
		return myItem;
	}

	public void setMyItem(List<ItemEntity> myItem) {
		this.myItem = myItem;
	}
	

}
