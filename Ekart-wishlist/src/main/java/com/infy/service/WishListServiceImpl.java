package com.infy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.WishListDTO;
import com.infy.repository.WishlistRepository;


@Service
public class WishListServiceImpl implements WishlistService{

	@Autowired
	WishlistRepository wishListRepo;
	
	@Autowired
	ProductFeignClient productClient;
	
	@Override
	public List<WishListDTO> getWishListUser(int userId) {
		// TODO Auto-generated method stub
		return wishListRepo.findByUserId(userId).stream().map((wishlist)->{
			WishListDTO wishList = WishListDTO.getDTO(wishlist);
			wishList.setProduct(productClient.getProduct(wishlist.getProductId()));
			return wishList;
		}).collect(Collectors.toList());
	}

	@Override
	public List<WishListDTO> addToWishList(WishListDTO wishList) {
		// TODO Auto-generated method stub
		wishListRepo.save(wishList.getEntity());
		return getWishListUser(wishList.getUserId());
	}

	@Override
	public List<WishListDTO> deleteWishList(int wishListId, int userId) {
		// TODO Auto-generated method stub
		wishListRepo.deleteById(wishListId);
		return getWishListUser(userId);
	}

}
