package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.CardDTO;
import com.infy.service.CardServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	CardServiceImpl cardService;
	
	@GetMapping("/getCardsByUser/{userId}")
	public List<CardDTO> getCardByUser(@PathVariable int userId){
		return cardService.getAllCardByUser(userId);
	}
	
	@PostMapping("/saveCard")
	public List<CardDTO> saveCard(@RequestBody CardDTO cardDTO){
		return cardService.saveCard(cardDTO);
	} 
	
	@PostMapping("/verify")
	public boolean verifyCard(@RequestBody CardDTO cardDTO) {
		return cardService.checkCard(cardDTO);
	}
	

}
