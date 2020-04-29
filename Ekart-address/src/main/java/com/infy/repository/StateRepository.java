package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.States;

public interface StateRepository extends JpaRepository<States, Integer>{
	List<States> findByCountry(String coutry);
}
