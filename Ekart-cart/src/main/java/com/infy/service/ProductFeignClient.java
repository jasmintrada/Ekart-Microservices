package com.infy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.dto.ProductDTO;

@FeignClient("ProductMS")
public interface ProductFeignClient {
	@RequestMapping("/product/recommend/{productId}")
	ProductDTO getProduct(@PathVariable("productId") int productId);
	
}
