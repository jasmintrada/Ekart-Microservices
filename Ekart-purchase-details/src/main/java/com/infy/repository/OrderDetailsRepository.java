package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	List<OrderDetails> findByUserId(int userId);
}
