package com.infy.dto;

import java.time.LocalDate;

import com.infy.entity.Card;

public class CardDTO {
	private int id;
	private String cardNo;
	private int cvv;
	private LocalDate expDate;
	private String userName;
	private double amount;
private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public static CardDTO getDTO(Card card) {
		CardDTO cardDTO = new CardDTO();
		cardDTO.setCardNo(card.getCardNo());
		cardDTO.setExpDate(card.getExpDate());
		cardDTO.setId(card.getId());
		cardDTO.setUserName(card.getUserName());
		cardDTO.setUserId(card.getUserId());
		return cardDTO;
	}
	public Card getEntity(Card card) {
		card = card==null? new Card():card;
		card.setAmount(this.getAmount());
		card.setCardNo(this.getCardNo());
		card.setCvv(this.getCvv());
		card.setExpDate(this.getExpDate());
		card.setId(this.getId());
		card.setUserName(this.getUserName());
		card.setUserId(this.getUserId());
		return card;
	}
}
