package com.infy.service;

import java.time.LocalDate;
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
	public List<CardDTO> saveCard(CardDTO card) throws Exception {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
		if(card.getExpDate().compareTo(today)<0) {
			throw new Exception("Card is outdated.");
		}
		List<Card> cards = cardRepo.findByUserId(card.getUserId());
		long size = cards.stream().filter((card1)->{ return card1.getCardNo().equals(card.getCardNo());}).count();
		if(size>0) throw new Exception("Card with this card number already exists.");
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

	@Override
	public List<CardDTO> deleteCard(int cardId,int userId) {
		// TODO Auto-generated method stub
		cardRepo.deleteById(cardId);
		return getAllCardByUser(userId);
	}

}
