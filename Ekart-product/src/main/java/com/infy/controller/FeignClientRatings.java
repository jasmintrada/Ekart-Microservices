package com.infy.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.dto.RatingsDTO;
import com.infy.util.Response;

@FeignClient("RatingMS")
public interface FeignClientRatings {
	@RequestMapping("/ratings/{productId}")
	Response<List<RatingsDTO>> getRatings(@PathVariable("productId") int productId);
	
}
