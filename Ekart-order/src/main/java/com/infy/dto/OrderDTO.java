package com.infy.dto;

import java.time.LocalDate;
import java.util.List;

import com.infy.entity.Order;


public class OrderDTO {
	private int id;
	private int userId;
	private double total;
	private String orderStatus;
	private LocalDate orderedDate;
	private LocalDate deliveryDate;
	private LocalDate returnDate;
	private LocalDate cancelledDate;
	private boolean btnReviewProduct;
	private boolean btnReviewSeller;
	private boolean btnCancel;
	private boolean btnReturn;
	private List<OrderDetailsDTO> orderDetails;
	
	public List<OrderDetailsDTO> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public LocalDate getCancelledDate() {
		return cancelledDate;
	}
	public void setCancelledDate(LocalDate cancelledDate) {
		this.cancelledDate = cancelledDate;
	}
	public boolean isBtnReviewProduct() {
		return btnReviewProduct;
	}
	public void setBtnReviewProduct(boolean btnReviewProduct) {
		this.btnReviewProduct = btnReviewProduct;
	}
	
	public boolean isBtnReviewSeller() {
		return btnReviewSeller;
	}
	public void setBtnReviewSeller(boolean btnReviewSeller) {
		this.btnReviewSeller = btnReviewSeller;
	}
	public boolean isBtnCancel() {
		return btnCancel;
	}
	public void setBtnCancel(boolean btnCancel) {
		this.btnCancel = btnCancel;
	}
	public boolean isBtnReturn() {
		return btnReturn;
	}
	public void setBtnReturn(boolean btnReturn) {
		this.btnReturn = btnReturn;
	}
	public static OrderDTO getDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBtnCancel(order.isBtnCancel());
		orderDTO.setBtnReturn(order.isBtnReturn());
		orderDTO.setBtnReviewProduct(order.isBtnReviewProduct());
		orderDTO.setBtnReviewSeller(order.isBtnReviewSeller());
		orderDTO.setCancelledDate(order.getCancelledDate());
		orderDTO.setDeliveryDate(order.getDeliveryDate());
		orderDTO.setId(order.getId());
		orderDTO.setOrderedDate(order.getOrderedDate());
		orderDTO.setReturnDate(order.getReturnDate());
		orderDTO.setTotal(order.getTotal());
		orderDTO.setUserId(order.getUserId());
		orderDTO.setOrderStatus(order.getOrderStatus());
		return orderDTO;
	}
	public Order getEntity() {
		Order orderDTO = new Order();
		orderDTO.setBtnCancel(this.isBtnCancel());
		orderDTO.setBtnReturn(this.isBtnReturn());
		orderDTO.setBtnReviewProduct(this.isBtnReviewProduct());
		orderDTO.setBtnReviewSeller(this.isBtnReviewSeller());
		orderDTO.setCancelledDate(this.getCancelledDate());
		orderDTO.setDeliveryDate(this.getDeliveryDate());
		orderDTO.setId(this.getId());
		orderDTO.setOrderedDate(this.getOrderedDate());
		orderDTO.setReturnDate(this.getReturnDate());
		orderDTO.setTotal(this.getTotal());
		orderDTO.setUserId(this.getUserId());
		orderDTO.setOrderStatus(this.getOrderStatus());
		return orderDTO;
	}
}
