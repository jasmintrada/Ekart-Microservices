package com.infy.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.CardDTO;
import com.infy.entity.Card;
import com.infy.repository.CardRepository;


@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardRepository cardRepo;
	
	@Override
	public List<CardDTO> saveCard(CardDTO card) {
		// TODO Auto-generated method stub
		if(card.getId()==0) {
			cardRepo.save(card.getEntity(null));
		}else {
			Card cardE = cardRepo.findById(card.getId()).get();
			cardRepo.save(card.getEntity(cardE));
		}
		return getAllCardByUser(card.getUserId());
	}

	@Override
	public List<CardDTO> getAllCardByUser(int userId) {
		// TODO Auto-generated method stub
		return cardRepo.findByUserId(userId).stream().map((card)->{
			return CardDTO.getDTO(card);
		}).collect(Collectors.toList());
	}

	@Override
	public boolean checkCard(CardDTO card) {
		// TODO Auto-generated method stub
		Card cardE = cardRepo.findById(card.getId()).get();
		return cardE.getCvv()==card.getCvv();
	}

}
