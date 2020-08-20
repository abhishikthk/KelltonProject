package com.shoppingcart.services;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.entities.ItemEntity;
import com.shoppingcart.entities.ProductEntity;
import com.shoppingcart.entities.UserEntity;
import com.shoppingcart.models.ItemModel;
import com.shoppingcart.models.ProductModel;

import com.shoppingcart.repositories.CategoryRepository;
import com.shoppingcart.repositories.ItemRepository;
import com.shoppingcart.repositories.ProductRepository;
import com.shoppingcart.repositories.UserRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	public ItemModel addToItem(long userID, long productID) {

		ProductEntity productEntity = productRepo.findById(productID).orElse(null);
		UserEntity userEntity = userRepo.findById(userID).orElse(new UserEntity());
		List<ItemEntity> itemEntityList = userEntity.getMyItem();

		ItemEntity itemEntity = new ItemEntity();
		// itemEntity.setItemID(productID);
		itemEntity.setProductID(productID);
		itemEntity.setCategoryEntity(productEntity.getCategoryEntity());
		itemEntity.setType(productEntity.getType());
		itemEntity.setName(productEntity.getName());
		itemEntity.setPrice(productEntity.getPrice());
		itemEntity.setDescription(productEntity.getDescription());
		itemEntity.setUserID(userID);

		itemEntityList.add(itemEntity);

		itemRepo.saveAll(itemEntityList);

		ItemModel itemModel = new ItemModel();
		itemModel.setProductID(productID);
		itemModel.setCategory(productEntity.getCategoryEntity().getCategoryName());
		itemModel.setType(productEntity.getType());
		itemModel.setName(productEntity.getName());
		itemModel.setPrice(productEntity.getPrice());
		itemModel.setDescription(productEntity.getDescription());
		itemModel.setUserID(userEntity.getUserID());

		return itemModel;
	}

	public String removeFromItem(long userID, long productID) {

		List<ItemEntity> itemEntityList = itemRepo.findByUserID(userID);

		UserEntity userEntity = userRepo.getOne(userID);
		
		
		List<ItemEntity> userItemList = userEntity.getMyItem();
		for (ItemEntity i : userItemList) {

			long id = i.getProductID();
			if (id == productID) {
				userItemList.remove(i);
				userRepo.save(userEntity);
			}
			
		}


		
		for (ItemEntity i : itemEntityList) {
			long id = i.getProductID();
			if (id == productID) {
				itemRepo.delete(i);
				
				
			}
			
		}

		return "Deleted";
	}

	@Transactional
	public List<ItemModel> getAllItems(long userID, int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		List<ItemEntity> itemEntity = itemRepo.findByUserID(userID, pageable);
		List<ItemModel> itemModelList = new ArrayList<>();

		for (ItemEntity i : itemEntity) {
			ItemModel im = new ItemModel();
			im.setProductID(i.getProductID());
			im.setDescription(i.getDescription());
			im.setName(i.getName());
			im.setPrice(i.getPrice());
			im.setType(i.getType());
			im.setUserID(i.getUserID());
			im.setCategory(i.getCategoryEntity().getCategoryName());
			itemModelList.add(im);
		}
		return itemModelList;

	}

	@Transactional
	public List<ItemModel> getAllItemsSortedByType(long userID, int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		List<ItemEntity> itemEntity = itemRepo.findByUserIDOrderByType(userID, pageable);
		List<ItemModel> itemModelList = new ArrayList<>();

		for (ItemEntity i : itemEntity) {
			ItemModel im = new ItemModel();
			im.setProductID(i.getProductID());
			im.setDescription(i.getDescription());
			im.setName(i.getName());
			im.setPrice(i.getPrice());
			im.setType(i.getType());
			im.setUserID(i.getUserID());
			im.setCategory(i.getCategoryEntity().getCategoryName());
			itemModelList.add(im);
		}
		return itemModelList;

	}

	@Transactional
	public List<ItemModel> getAllItemsSortedByPrice(long userID, int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		List<ItemEntity> itemEntity = itemRepo.findByUserIDOrderByPriceDesc(userID, pageable);
		List<ItemModel> itemModelList = new ArrayList<>();

		for (ItemEntity i : itemEntity) {
			ItemModel im = new ItemModel();
			im.setProductID(i.getProductID());
			im.setDescription(i.getDescription());
			im.setName(i.getName());
			im.setPrice(i.getPrice());
			im.setType(i.getType());
			im.setUserID(i.getUserID());
			im.setCategory(i.getCategoryEntity().getCategoryName());
			itemModelList.add(im);
		}
		return itemModelList;

		
	}

}
