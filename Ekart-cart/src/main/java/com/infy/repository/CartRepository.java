package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByUserId(int userId);
	List<Cart> findByUserIdAndProductId(int userId,int productId);
}
