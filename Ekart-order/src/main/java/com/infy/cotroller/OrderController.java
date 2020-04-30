package com.infy.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.OrderDTO;
import com.infy.service.OrderServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@GetMapping("/viewOrders/{userId}")
	public List<OrderDTO> viewOrders(@PathVariable int userId) throws Exception{
		return orderService.getOrdersForUser(userId);
	} 

}
