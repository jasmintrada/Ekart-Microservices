package com.infy.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.repository.StateRepository;

@Service
public class StateService {
	@Autowired
	private StateRepository stateRepo;
	
	public List<String> getStates(String country){
		List<String> states =  stateRepo.findByCountry(country).stream().map((state)->{return state.getState();}).collect(Collectors.toList());
		Collections.sort(states);
		return states;
	}
	
}
