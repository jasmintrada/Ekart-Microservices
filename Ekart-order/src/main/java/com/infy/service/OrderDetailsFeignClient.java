package com.infy.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.dto.OrderDetailsDTO;

@FeignClient("PurchaseDetailsMS")
public interface OrderDetailsFeignClient {

	@RequestMapping("orderDetails/orderDetails/{orderId}")
	List<OrderDetailsDTO> getDetails(@PathVariable("orderId") int orderId);
	
}
