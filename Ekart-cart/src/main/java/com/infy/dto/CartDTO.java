package com.infy.dto;

import com.infy.entity.Cart;

public class CartDTO {
	private int id;
	private int userId;
	private ProductDTO product;
	private int quantity;
	private double totalProductPrice;
	private double cartPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalProductPrice() {
		return totalProductPrice;
	}
	public void setTotalProductPrice(double totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}
	public double getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}
	
	public static CartDTO getDTO(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(cart.getId());
		cartDTO.setCartPrice(cart.getCartPrice());
		cartDTO.setQuantity(cart.getQuantity());
		cartDTO.setTotalProductPrice(cart.getTotalProductPrice());
		ProductDTO product = new ProductDTO();
		product.setId(cart.getProductId());
		cartDTO.setProduct(product);
		cartDTO.setUserId(cart.getUserId());
		return cartDTO;
	}
	
	public Cart getEntity() {
		Cart cart = new Cart();
		cart.setProductId(this.getProduct().getId());
		cart.setCartPrice(this.getCartPrice());
		cart.setQuantity(this.getQuantity());
		cart.setTotalProductPrice(this.getTotalProductPrice());
		cart.setUserId(this.getUserId());
		return cart;
	}
	
}
