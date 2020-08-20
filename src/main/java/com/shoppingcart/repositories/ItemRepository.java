package com.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entities.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

	List<ItemEntity> findByUserID(long userID);
	
	List<ItemEntity> findByProductID(long productID);
	
	List<ItemEntity> findByUserID(long userID, Pageable pageable);
	
	List<ItemEntity> findByUserIDOrderByType(long userID, Pageable pageable);
	
	List<ItemEntity> findByUserIDOrderByPriceDesc(long userID, Pageable pageable);

	List<ItemEntity> findByNameAndDescription(String name, String description);
	
	
//	ItemEntity findByProductIDIn(List<ItemEntity> itemList);
//	
//	
//	List<ItemEntity> findByUserIDAndProductID(long userID, long productID);
	
}
