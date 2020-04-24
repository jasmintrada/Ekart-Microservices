package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByDisplayNameStartsWith(String productName);
}
