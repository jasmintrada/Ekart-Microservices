package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findByUserId(int userId);
}
