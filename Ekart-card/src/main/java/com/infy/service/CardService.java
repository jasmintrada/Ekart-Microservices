package com.infy.service;

import java.util.List;

import com.infy.dto.CardDTO;

public interface CardService {
	List<CardDTO> saveCard(CardDTO card);
	List<CardDTO> getAllCardByUser(int userId);
	boolean checkCard(CardDTO card);
	List<CardDTO> deleteCard(int cardId,int userId);
}
