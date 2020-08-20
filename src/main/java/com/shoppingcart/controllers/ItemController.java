package com.shoppingcart.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.entities.ItemEntity;
import com.shoppingcart.models.ItemModel;
import com.shoppingcart.services.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/addtoitem/userid/{userID}/productid/{productID}")
	public ItemModel addToItem(@PathVariable long userID, @PathVariable long productID) {
		return itemService.addToItem(userID, productID);
	}

	@DeleteMapping("/removefromitem/userid/{userID}/productid/{productID}")
	public String removeFromItem(@PathVariable long userID, @PathVariable long productID) {
		return itemService.removeFromItem(userID, productID);
	}
	
	@GetMapping("/getallitems/userid/{userID}/page/{page}/size/{size}")
	public List<ItemModel> getAllItems(@PathVariable long userID, @PathVariable int page , @PathVariable int size){
		return itemService.getAllItems(userID,page,size);
	}
	
	@GetMapping("/getallitemssortedbytype/userid/{userID}/page/{page}/size/{size}")
	public List<ItemModel> getAllItemsSortedByType(@PathVariable long userID, @PathVariable int page , @PathVariable int size){
		return itemService.getAllItemsSortedByType(userID,page,size);
	}
	
	@GetMapping("/getallitemssortedbyprice/userid/{userID}/page/{page}/size/{size}")
	public List<ItemModel> getAllItemsSortedByPrice(@PathVariable long userID, @PathVariable int page , @PathVariable int size){
		return itemService.getAllItemsSortedByPrice(userID,page,size);
	}
	
	
}
