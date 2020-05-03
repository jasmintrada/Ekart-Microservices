package com.infy.service;

import java.util.List;

import com.infy.dto.WishListDTO;

public interface WishlistService {
	List<WishListDTO> getWishListUser(int userId);
	List<WishListDTO> addToWishList(WishListDTO wishList);
	List<WishListDTO> deleteWishList(int wishListId,int userId);
}
