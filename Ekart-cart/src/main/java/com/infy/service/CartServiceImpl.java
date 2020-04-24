package com.infy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.CartDTO;
import com.infy.dto.ProductDTO;
import com.infy.entity.Cart;
import com.infy.repository.CartRepository;
import com.infy.util.CartException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	ProductFeignClient productClient;
	
	@Override
	public List<CartDTO> getCartByUser(int userId) throws CartException {
		// TODO Auto-generated method stub
		List<Cart> cartList = cartRepo.findByUserId(userId);
		List<CartDTO> cartDTOList = new ArrayList<>();
		if(cartList==null||cartList.size()==0)throw new CartException("You Do not have any items in the cart.");
		for(Cart cart:cartList) {
			CartDTO cartDTO = CartDTO.getDTO(cart);
			ProductDTO product = productClient.getProduct(cart.getProductId());
			cartDTO.setProduct(product);
			cartDTOList.add(cartDTO);
		}
		return cartDTOList;
	}

	@Override
	public String addToCart(CartDTO cartDTO) throws CartException {
		// TODO Auto-generated method stub
		try {
		
			List<Cart> cartList = cartRepo.findByUserId(cartDTO.getUserId());
			boolean flag = false;
			for(Cart tmpCart:cartList) {
				tmpCart.setCartPrice(cartDTO.getCartPrice());
				if(tmpCart.getId()==cartDTO.getId()) {
					tmpCart.setQuantity(tmpCart.getQuantity()+cartDTO.getQuantity());
					tmpCart.setTotalProductPrice(tmpCart.getTotalProductPrice()+cartDTO.getTotalProductPrice());
					flag = true;
				}
			}
			if(!flag)
			cartRepo.save(cartDTO.getEntity());
			cartRepo.saveAll(cartList);
		}catch(Exception e) {
			throw new CartException(e.getMessage());
		}return "Added";
		
	}

	@Override
	public String removeFromCart(int userId,int productId) throws CartException {
		// TODO Auto-generated method stub
		try {
			Cart cart = cartRepo.findByUserIdAndProductId(userId, productId).get(0);
			double price = cart.getCartPrice()-cart.getTotalProductPrice();
			List<Cart> cartList = cartRepo.findByUserId(cart.getUserId());
			for(Cart tmpCart:cartList) {
				tmpCart.setCartPrice(price);
			}
			cartRepo.saveAll(cartList);
			cartRepo.deleteById(cart.getId());
		}catch(Exception e) {
			throw new CartException(e.getMessage());
		}
		return "Removed.";
	}

	@Override
	public void updateCart(CartDTO cartDTO) throws CartException {
		// TODO Auto-generated method stub
		try {
			
			List<Cart> cartList = cartRepo.findByUserId(cartDTO.getUserId());
			for(Cart tmpCart:cartList) {
				tmpCart.setCartPrice(cartDTO.getCartPrice());
				if(tmpCart.getProductId()==cartDTO.getProduct().getId()) {
					tmpCart.setQuantity(cartDTO.getQuantity());
					tmpCart.setTotalProductPrice(cartDTO.getTotalProductPrice());
				}
			}
			cartRepo.saveAll(cartList);
		}catch(Exception e) {
			throw new CartException(e.getMessage());
		}
	}

	
}
