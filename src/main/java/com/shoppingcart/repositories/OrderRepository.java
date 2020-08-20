package com.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity , Long> {

	List<OrderEntity> findByUserID(long userID, Pageable pageable);

	List<OrderEntity> findByUserIDOrderByPriceDesc(long userID, Pageable pageable);

}
