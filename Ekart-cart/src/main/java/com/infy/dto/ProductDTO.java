package com.infy.dto;

import java.util.List;


public class ProductDTO {
	private int id;
	private String displayName;
	private String desc;
	private String shortDesc;
	private String category;
	private double price;
	private double discount;
	private double deliveryCharge;
	private double offerPrice;
	private List<RatingsDTO> ratings;
	private double avgRating;
	
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public List<RatingsDTO> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingsDTO> ratings) {
		this.ratings = ratings;
	}
	
}
