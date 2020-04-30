package com.infy.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.infy.dto.OrderDetailsDTO;
import com.infy.dto.ProductDTO;
import com.infy.util.OrderDetailsException;

public interface OrderDetailsService {
	List<ProductDTO> getOrderDetails(int userId) throws OrderDetailsException, InterruptedException, ExecutionException;
	List<OrderDetailsDTO> getDetails(int orderId);
}
