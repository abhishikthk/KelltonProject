package com.shoppingcart.services;

import java.util.*;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entities.ItemEntity;
import com.shoppingcart.entities.ProductEntity;
import com.shoppingcart.models.ProductModel;
import com.shoppingcart.repositories.ItemRepository;
import com.shoppingcart.repositories.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired 
	
	@Transactional public List<ProductModel> getAllProducts(){
		
		List<ProductModel> productModel = new ArrayList<>();

		List<ProductEntity> productEntity = productRepo.findAll();
		
		for(ProductEntity p:productEntity) {
			ProductModel pm = new ProductModel();
			pm.setProductID(p.getProductID());
			pm.setCategory(p.getCategoryEntity().getCategoryName());
			pm.setName(p.getName());
			pm.setPrice(p.getPrice());
			pm.setDescription(p.getDescription());
			pm.setType(p.getType());
			
			productModel.add(pm);
		}
		
		return productModel;
	}
	
	@Transactional public String updateProduct(long productID, double newPrice) {
		ProductEntity productEntity = productRepo.findById(productID).orElse(new ProductEntity());
		productEntity.setPrice(newPrice);
		productRepo.save(productEntity);
		
		List<ItemEntity> itemEntity = itemRepo.findByProductID(productID);
		for(ItemEntity i:itemEntity) {
			i.setPrice(newPrice);
		}
		
		
		return "Price changed to "+newPrice;
		
	}
	
	@Transactional public String updateProductByColour(String name, String description, double newPrice) {
//		List<ProductEntity> productEntity = productRepo.findByName(name);
//		
//		for(ProductEntity p:productEntity) {
//			if(p.getDescription().equalsIgnoreCase(description)) {
//				p.setPrice(newPrice);
//			}
//		}
		
		ProductEntity productEntity = productRepo.findByNameAndDescription(name, description);
		productEntity.setPrice(newPrice);
		
		List<ItemEntity> itemEntity = itemRepo.findByNameAndDescription(name, description);
		for(ItemEntity i:itemEntity) {
			i.setPrice(newPrice);
		}
		
		//productRepo.saveAll(productEntity);
		return "Price changed to "+newPrice;
		
	}

	public ProductModel findProductByNameAndColour(String name, String description) {
		ProductEntity productEntity = productRepo.findByNameAndDescription(name, description);
		ProductModel productModel = new ProductModel();
		
		productModel.setProductID(productEntity.getProductID());
		productModel.setDescription(productEntity.getDescription());
		productModel.setName(productEntity.getName());
		productModel.setPrice(productEntity.getPrice());
		productModel.setType(productEntity.getType());
		productModel.setCategory(productEntity.getCategoryEntity().getCategoryName());
		
		return productModel;
		
		
	}
	
}
