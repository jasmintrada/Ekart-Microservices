package com.infy.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.ProductDTO;
import com.infy.service.OrderDetailsServiceImpl;
import com.infy.util.OrderDetailsException;
import com.infy.util.Response;

@RestController
@CrossOrigin
@RequestMapping("/orderDetails")
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsServiceImpl orderService;
	
	
	
	@GetMapping("/purchasedProduct/{userId}")
	public Response<List<ProductDTO>> getProductsOfUser(@PathVariable int userId) throws OrderDetailsException, InterruptedException, ExecutionException{
		List<ProductDTO> productList = orderService.getOrderDetails(userId);
		Response<List<ProductDTO>> response = new Response<List<ProductDTO>>();
		response.setCode(HttpStatus.OK.value());
		response.setMsg(productList);
		return response;
	}
}
