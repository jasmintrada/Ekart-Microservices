package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.CartDTO;
import com.infy.service.CartServiceImpl;
import com.infy.util.CartException;
import com.infy.util.Response;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartServiceImpl cartService;
	
	@GetMapping("/getDetails/{userId}")
	public Response<List<CartDTO>> getCartDetails(@PathVariable int userId) throws CartException{
		Response<List<CartDTO>> response=  new Response<>();
		List<CartDTO> cartList = cartService.getCartByUser(userId);
		response.setMessage(cartList);
		response.setData(HttpStatus.OK.value());
		return response;
	}
	
	@PostMapping("/addToCart")
	public Response<String> addToCart(@RequestBody CartDTO cartDTO) throws CartException{
		Response<String> response = new Response<String>();
		response.setMessage(cartService.addToCart(cartDTO));
		response.setData(HttpStatus.OK.value());
		return response;
	}
	
	@PostMapping("/updateCart")
	public Response<String> updateCart(@RequestBody CartDTO cartDTO) throws CartException{
		Response<String> response = new Response<String>();
		System.out.println(cartDTO.getQuantity()+" "+cartDTO.getTotalProductPrice());
		cartService.updateCart(cartDTO);
		response.setMessage("Success");
		response.setData(HttpStatus.OK.value());
		return response;
	}
	
	@GetMapping("/remove/{userId}/{productId}")
	public Response<List<CartDTO>> removeFromCart(@PathVariable int userId,@PathVariable int productId) throws CartException{
		String msg = cartService.removeFromCart(userId,productId);
		return getCartDetails(userId);
	}
 	
}
