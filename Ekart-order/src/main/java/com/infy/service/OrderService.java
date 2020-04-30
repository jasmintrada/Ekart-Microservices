package com.infy.service;

import java.util.List;

import com.infy.dto.OrderDTO;

public interface OrderService {
	List<OrderDTO> getOrdersForUser(int userId) throws Exception;
	
}
