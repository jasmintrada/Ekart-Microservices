package com.infy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepo;
	
	public List<String> getCities(){
		return cityRepo.findAll().stream().map((city)->{return city.getName();}).collect(Collectors.toList());
	}
}
