package com.infy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Deals;

public interface DealsRepository extends JpaRepository<Deals, Integer> {
	List<Deals> findByDealDate(String dealDate);
}
