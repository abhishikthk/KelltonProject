package com.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.entities.ItemEntity;
import com.shoppingcart.entities.OrderEntity;
import com.shoppingcart.entities.UserEntity;
import com.shoppingcart.models.ItemModel;
import com.shoppingcart.models.OrderModel;
import com.shoppingcart.repositories.ItemRepository;
import com.shoppingcart.repositories.OrderRepository;
import com.shoppingcart.repositories.UserRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private UserRepository userRepo;



	
	public List<OrderModel> moveToOrder(long userID) {

		

		List<OrderEntity> orderEntitylist = new ArrayList<>();

		List<ItemEntity> itemEntityList = itemRepo.findByUserID(userID);

		UserEntity userEntity = userRepo.getOne(userID);
		
		
		for (ItemEntity i : itemEntityList) {
			OrderEntity om = new OrderEntity();
			om.setDescription(i.getDescription());
			om.setName(i.getName());
			om.setPrice(i.getPrice());
			om.setProductID(i.getProductID());
			om.setType(i.getType());
			om.setUserID(i.getUserID());
			om.setCategoryEntity(i.getCategoryEntity());
			orderEntitylist.add(om);	
		}
		
	//Method to clear cart after order	
		itemRepo.findByUserID(userID).removeAll(itemEntityList);
		userEntity.getMyItem().clear();

//		List<ItemEntity> userItemList = userEntity.getMyItem();
//		for (ItemEntity i : userItemList) {
//				userItemList.remove(i);
//				userRepo.save(userEntity);
//		}
		
//		for (ItemEntity i : itemEntityList) {
//				itemRepo.delete(i);
//		}
				
		userEntity.setMyOrder(orderEntitylist);
		
		
		
		
		orderRepo.saveAll(orderEntitylist);

		List<OrderModel> orderModellist = new ArrayList<>();
		for (ItemEntity i : itemEntityList) {
			OrderModel om = new OrderModel();
			om.setDescription(i.getDescription());
			om.setName(i.getName());
			om.setPrice(i.getPrice());
			om.setProductID(i.getProductID());
			om.setType(i.getType());
			om.setUserID(i.getUserID());
			om.setCategory(i.getCategoryEntity().getCategoryName());
			orderModellist.add(om);
		}

		return orderModellist;

	}

	public List<OrderModel> moveToOrderPaged(long userID, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		List<OrderEntity> orderEntityList = orderRepo.findByUserID(userID, pageable);
		
		List<OrderModel> orderModellist = new ArrayList<>();
		
		for (OrderEntity o : orderEntityList) {
			OrderModel om = new OrderModel();
			om.setDescription(o.getDescription());
			om.setName(o.getName());
			om.setPrice(o.getPrice());
			om.setProductID(o.getProductID());
			om.setType(o.getType());
			om.setUserID(o.getUserID());
			om.setCategory(o.getCategoryEntity().getCategoryName());
			orderModellist.add(om);
		}
		return orderModellist;
	}
	
	@Transactional
	public List<OrderModel> getAllOrderssSortedByPrice(long userID, int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		List<OrderEntity> orderEntity = orderRepo.findByUserIDOrderByPriceDesc(userID, pageable);
		
		List<OrderModel> orderModelList = new ArrayList<>();

		for (OrderEntity o : orderEntity) {
			OrderModel om = new OrderModel();
			om.setProductID(o.getProductID());
			om.setDescription(o.getDescription());
			om.setName(o.getName());
			om.setPrice(o.getPrice());
			om.setType(o.getType());
			om.setUserID(o.getUserID());
			om.setCategory(o.getCategoryEntity().getCategoryName());
			orderModelList.add(om);
		}
		return orderModelList;

	}

}
