package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name = "ratingsGenerator",strategy = "native")
public class Ratings {
	@Id
	@GeneratedValue(generator = "ratingsGenerator")
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
	
}
