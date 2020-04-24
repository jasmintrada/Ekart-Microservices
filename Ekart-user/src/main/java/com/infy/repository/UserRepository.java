package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByEmailId(String email);
}
