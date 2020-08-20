package com.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.ProductModel;
import com.shoppingcart.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/getallproducts")
	public List<ProductModel> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PutMapping("/updateproduct/productid/{productID}/newprice/{newPrice}")
	public String updateProduct(@PathVariable long productID, @PathVariable double newPrice) {
		return productService.updateProduct(productID, newPrice);
	}
	
	@PutMapping("/updateproductbycolour/name/{name}/description/{description}/newprice/{newPrice}")
	public String updateProductByColour(@PathVariable String name, @PathVariable String description, @PathVariable double newPrice) {
		return productService.updateProductByColour(name, description, newPrice);
	}
	
	@GetMapping("/findproductbynameandcolour/name/{name}/description/{description}")
	public ProductModel findProductByNameAndColour(@PathVariable String name, @PathVariable String description) {
		return productService.findProductByNameAndColour(name, description);
	}
}
