package com.infy.dto;

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
	
}
