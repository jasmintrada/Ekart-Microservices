package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {
	List<Ratings> findByProductId(int productId);
}
