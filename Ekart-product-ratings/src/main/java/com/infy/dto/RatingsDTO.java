package com.infy.dto;

import com.infy.entity.Ratings;

public class RatingsDTO {
	private int id;
	private String userName;
	private int productId;
	private double ratings;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Ratings getRating() {
		Ratings ratings = new Ratings();
		ratings.setId(this.getId());
		ratings.setProductId(this.getProductId());
		ratings.setRatings(this.getRatings());
		ratings.setUserName(this.getUserName());
		ratings.setComments(this.getComments());
		return ratings;
	}
	public static RatingsDTO getRatingsDTO(Ratings ratings) {
		RatingsDTO ratingsDTO = new RatingsDTO();
		ratingsDTO.setComments(ratings.getComments());
		ratingsDTO.setProductId(ratings.getProductId());
		ratingsDTO.setRatings(ratings.getRatings());
		ratingsDTO.setId(ratings.getId());
		ratingsDTO.setUserName(ratings.getUserName());
		return ratingsDTO;
	}
}
