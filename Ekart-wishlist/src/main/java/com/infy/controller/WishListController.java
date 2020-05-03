package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.WishListDTO;
import com.infy.service.WishListServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/wishlist")
public class WishListController {
	
	@Autowired
	WishListServiceImpl wishListService;
	
	@GetMapping("/getWishList/{userId}")
	public List<WishListDTO> getWishListByUser(@PathVariable int userId){
		return wishListService.getWishListUser(userId);
	} 
	
	@PostMapping("/addToWishList")
	public List<WishListDTO> addToWishList(@RequestBody WishListDTO wishListDTO){
		return wishListService.addToWishList(wishListDTO);
	}
	
	@GetMapping("/remove/{wishListId}/{userId}")
	public List<WishListDTO> removeFromWishList(@PathVariable int wishListId,@PathVariable int userId){
		return wishListService.deleteWishList(wishListId, userId);
	}
	
}
