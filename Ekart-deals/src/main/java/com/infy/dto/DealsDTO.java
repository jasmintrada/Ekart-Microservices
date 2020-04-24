package com.infy.dto;

import java.util.Date;

import com.infy.entity.Deals;

public class DealsDTO {
private int id;
	
	private String dealDate;
	
	private String category;
	
	private double discount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public static DealsDTO getDTO(Deals deal) {
		DealsDTO dealsDTO = new DealsDTO();
		dealsDTO.setCategory(deal.getCategory());
		dealsDTO.setId(deal.getId());
		dealsDTO.setDealDate(deal.getDealDate());
		dealsDTO.setDiscount(deal.getDiscount());
		return dealsDTO;
	}
	public Deals getEntity() {
		Deals deal = new Deals();
		deal.setCategory(this.getCategory());
		deal.setDealDate(this.getDealDate());
		deal.setDiscount(this.getDiscount());
		deal.setId(this.getId());
		return deal;
	}
}
