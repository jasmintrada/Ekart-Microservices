package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.RatingsDTO;
import com.infy.service.RatingsServiceImpl;
import com.infy.utils.RatingsException;
import com.infy.utils.Response;

@RestController
@CrossOrigin
@RequestMapping("/ratings")
public class RatingsController {
	
	@Autowired
	RatingsServiceImpl ratingService;
	
	@GetMapping("/{productId}")
	public Response<List<RatingsDTO>> getRatings(@PathVariable int productId) throws RatingsException{
		List<RatingsDTO> ratings = ratingService.getRatings(productId);
		System.out.println(ratings.size());
		Response<List<RatingsDTO>> response = new Response<List<RatingsDTO>>();
		response.setMessage(ratings);
		response.setCode(HttpStatus.OK.value());
		return response;
	}
	
}
