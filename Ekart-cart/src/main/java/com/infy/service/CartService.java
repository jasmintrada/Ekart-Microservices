package com.infy.service;

import java.util.List;

import com.infy.dto.CartDTO;
import com.infy.util.CartException;

public interface CartService {
	List<CartDTO> getCartByUser(int userId) throws CartException;
	String addToCart(CartDTO cartDTO)  throws CartException;
	String removeFromCart(int userId,int productId) throws CartException;
	void updateCart(CartDTO cartDTO) throws CartException;
}
