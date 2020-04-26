package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.service.CityService;
import com.infy.service.StateService;

@RestController
@CrossOrigin
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/city")
	public List<String> getAllCities(){
		return cityService.getCities();
	}
	
	@GetMapping("/states/{city}")
	public List<String> getStateByCity(@PathVariable String city){
		return stateService.getStates(city);
	}
	
	
	
}
