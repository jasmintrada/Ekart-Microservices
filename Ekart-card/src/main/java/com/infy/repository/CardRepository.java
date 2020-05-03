package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
	List<Card> findByUserId(int userId);
}
