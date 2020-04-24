package com.infy.controller;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.DealsDTO;
import com.infy.dto.RatingsDTO;
import com.infy.util.Response;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class HystrixService {

	@Autowired
	FeignClientRatings ratingFeign;
	
	@Autowired
	FeignClientDeals dealFeign;
	
	@HystrixCommand
	public Future<Response<List<RatingsDTO>>> getRatings(int productId){
		return new AsyncResult<Response<List<RatingsDTO>>>() {
			@Override
			public Response<List<RatingsDTO>> invoke() {
				return ratingFeign.getRatings(productId);
			}
		};
	}
	
	@HystrixCommand
	public Future<Response<List<DealsDTO>>> getDeals(String dealDate){
		return new AsyncResult<Response<List<DealsDTO>>>() {
			@Override
			public Response<List<DealsDTO>> invoke() {
				return dealFeign.getDeals(dealDate);
			}
		};
	}
}
