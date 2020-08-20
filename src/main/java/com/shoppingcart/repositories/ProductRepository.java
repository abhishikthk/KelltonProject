package com.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
	
	
	List<ProductEntity> findByName(String name);
	ProductEntity findByNameAndDescription(String name, String description);

}
