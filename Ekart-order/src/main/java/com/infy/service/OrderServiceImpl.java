package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.OrderDTO;
import com.infy.entity.Orders;
import com.infy.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderDetailsFeignClient OrderDetailsClient;
	
	@Autowired
	private AddressFeignClient addressClient;
	
	@Override
	public List<OrderDTO> getOrdersForUser(int userId) throws Exception {
		// TODO Auto-generated method stub
		List<OrderDTO> orders = orderRepo.findByUserId(userId).stream().sorted(
				(o1,o2)->{
					return o2.getOrderedDate().compareTo(o1.getOrderedDate());
				}).map(
					(order)->{
						OrderDTO orderDTO = OrderDTO.getDTO(order);
						orderDTO.setOrderDetails(OrderDetailsClient.getDetails(order.getId()));
						orderDTO.setShippingAddress(addressClient.getAddressById(order.getShippingAddress()));
						return orderDTO;
					}).collect(Collectors.toList());
		return orders;
	}

}
