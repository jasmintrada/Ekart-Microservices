package com.infy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.OrderDetailsDTO;
import com.infy.dto.ProductDTO;
import com.infy.entity.OrderDetails;
import com.infy.repository.OrderDetailsRepository;
import com.infy.util.OrderDetailsException;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	
	@Autowired
	OrderDetailsRepository orderRepo;
	
	
	@Autowired
	ProductFeignClient productClient;
	@Override
	public List<ProductDTO> getOrderDetails(int userId) throws OrderDetailsException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		List<OrderDetails> orderDetails = orderRepo.findByUserId(userId);
		if(orderDetails!=null) {
			if(orderDetails.size()>0) {
				List<ProductDTO> productList = new ArrayList<>();
				HashSet<Integer> productSet = new HashSet<>();
				
				for(OrderDetails order:orderDetails) {
					productSet.add(order.getProductId());
				}
				for(int id:productSet) {
					ProductDTO product = productClient.getProduct(id);
					productList.add(product);
				}
				return productList;
			}
		}
		throw new OrderDetailsException("User has not purchased anything yet.");
	}
	@Override
	public List<OrderDetailsDTO> getDetails(int orderId) {
		// TODO Auto-generated method stub
		List<OrderDetailsDTO> orderDetails = orderRepo.findByOrderId(orderId).stream().map((od)->{
			OrderDetailsDTO odDTO = OrderDetailsDTO.getDTO(od);
			odDTO.setProduct(productClient.getProduct(od.getProductId()));
			return odDTO;
		}).collect(Collectors.toList());
		return orderDetails;
	}

}
