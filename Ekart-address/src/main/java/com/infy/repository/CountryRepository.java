package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Countries;

public interface CountryRepository extends JpaRepository<Countries, Integer>{

}
