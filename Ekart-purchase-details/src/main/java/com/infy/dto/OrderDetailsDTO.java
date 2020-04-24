package com.infy.dto;

import com.infy.entity.OrderDetails;

public class OrderDetailsDTO {
	private int id;
	private int orderId;
	private int userId;
	private ProductDTO product;
	private int quantity;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public static OrderDetailsDTO getDTO(OrderDetails order) {
		OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
		orderDetailsDTO.setId(order.getId());
		orderDetailsDTO.setOrderId(order.getOrderId());
		orderDetailsDTO.setPrice(order.getPrice());
		orderDetailsDTO.setQuantity(order.getQuantity());
		orderDetailsDTO.setUserId(order.getUserId());
		ProductDTO product = new ProductDTO();
		product.setId(order.getProductId());
		orderDetailsDTO.setProduct(product);
		
		return orderDetailsDTO;
	}
	public OrderDetails getEntity() {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderId(this.getOrderId());
		orderDetails.setPrice(this.getPrice());
		orderDetails.setProductId(this.getProduct().getId());
		orderDetails.setQuantity(this.getQuantity());
		orderDetails.setUserId(this.getUserId());
		return orderDetails;
	}
}
