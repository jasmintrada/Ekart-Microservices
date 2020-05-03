package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{
	List<Orders> findByUserId(int userId);
}
