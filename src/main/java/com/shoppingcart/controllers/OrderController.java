package com.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.OrderModel;
import com.shoppingcart.repositories.OrderRepository;
import com.shoppingcart.services.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/movetoorder/userid/{userID}")
	public List<OrderModel> moveToOrder(@PathVariable long userID){
		 return orderService.moveToOrder(userID);
	 }
	
	@GetMapping("/orderspaged/userid/{userID}/page/{page}/size/{size}")
	public List<OrderModel> moveToOrderPaged(@PathVariable long userID, @PathVariable int page, @PathVariable int size){
		 return orderService.moveToOrderPaged(userID, page, size);
	 }

	@GetMapping("/orderssortedbyprice/userid/{userID}/page/{page}/size/{size}")
	public List<OrderModel> getAllOrderssSortedByPrice(@PathVariable long userID, @PathVariable int page, @PathVariable int size){
		 return orderService.getAllOrderssSortedByPrice(userID, page, size);
	 }

	
}
