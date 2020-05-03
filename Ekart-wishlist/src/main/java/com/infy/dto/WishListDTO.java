package com.infy.dto;

import com.infy.entity.Wishlist;

public class WishListDTO {
	private int id;
	private ProductDTO product;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public static WishListDTO getDTO(Wishlist wishlist) {
		WishListDTO wishListDTO = new WishListDTO();
		wishListDTO.setId(wishlist.getId());
		wishListDTO.setUserId(wishlist.getUserId());
		return wishListDTO;
	}
	public Wishlist getEntity() {
		Wishlist wishlist = new Wishlist();
		wishlist.setId(this.getId());
		wishlist.setUserId(this.getUserId());
		wishlist.setProductId(this.getProduct().getId());
		
		return wishlist;
	}
}
