package com.infy.dto;

import java.util.List;

import com.infy.entity.Product;

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
	
	public static ProductDTO getDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setCategory(product.getCategory());
		productDTO.setDeliveryCharge(product.getDeliveryCharge());
		productDTO.setDesc(product.getDesc());
		productDTO.setDisplayName(product.getDisplayName());
		productDTO.setShortDesc(product.getShortDesc());
		productDTO.setDiscount(product.getDiscount());
		productDTO.setPrice(product.getPrice());
		productDTO.setOfferPrice(product.getOfferPrice());
		productDTO.setId(product.getId());
		productDTO.setAvgRating(product.getAvgRating());
		return productDTO;
	}
	public Product getproduct() {
		Product productDTO = new Product();
		productDTO.setCategory(this.getCategory());
		productDTO.setDeliveryCharge(this.getDeliveryCharge());
		productDTO.setDesc(this.getDesc());
		productDTO.setDisplayName(this.getDisplayName());
		productDTO.setShortDesc(this.getShortDesc());
		productDTO.setOfferPrice(this.getOfferPrice());
		productDTO.setDiscount(this.getDiscount());
		productDTO.setPrice(this.getPrice());
		productDTO.setId(this.getId());
		productDTO.setAvgRating(this.getAvgRating());
		return productDTO;
	}
	
}
