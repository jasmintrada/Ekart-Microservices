package com.infy.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepo;
	
	public List<String> getCities(){
		List<String> countries =  countryRepo.findAll().stream().map((city)->{return city.getName();}).collect(Collectors.toList());
		Collections.sort(countries);
		return countries;
	}
}
