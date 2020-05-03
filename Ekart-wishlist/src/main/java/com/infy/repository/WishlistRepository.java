package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {
	List<Wishlist> findByUserId(int userId);
}
