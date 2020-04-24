package com.infy.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.dto.DealsDTO;
import com.infy.util.Response;

@FeignClient("DealsMS")
public interface FeignClientDeals {
	@RequestMapping("/deals/getDeals/{dealDate}")
	Response<List<DealsDTO>> getDeals(@PathVariable("dealDate") String dealDate); 
}
