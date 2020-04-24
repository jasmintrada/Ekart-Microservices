package com.infy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.DealsDTO;
import com.infy.dto.ProductDTO;
import com.infy.dto.RatingsDTO;
import com.infy.service.ProductServiceImpl;
import com.infy.util.ProductException;
import com.infy.util.Response;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl prodService;
	
	@Autowired
	HystrixService hystrixService;
	
	
	@GetMapping("/getProducts")
	public Response<List<ProductDTO>> getAllproduct() throws InterruptedException, ExecutionException{
		Response<List<ProductDTO>> response = new Response<List<ProductDTO>>();
		
		response.setMessage(prodService.getAllProducts());
		for(ProductDTO product:response.getMessage()) {
			List<DealsDTO> deals = hystrixService.getDeals("Apr-20-2020").get().getMessage();
			double discount = 0;
			for(DealsDTO deal:deals) {
				if(deal.getCategory().equals(product.getCategory())) {
					discount = deal.getDiscount();
					break;
				}
			}
			if(discount>0) {
				double price = product.getOfferPrice()*(1-(discount/100));
				product.setOfferPrice(price);
				price = product.getPrice()-price;
				price*=100;
				product.setDiscount((price/product.getPrice()));
			}
		}
		response.setCode(HttpStatus.OK.value());
		return response;
	}
	@GetMapping("recommend/{productId}")
	public ProductDTO getRecommendedProduct(@PathVariable int productId) throws ProductException, InterruptedException, ExecutionException{
		ProductDTO product = prodService.getSpecificProduct(productId);
		List<DealsDTO> deals = hystrixService.getDeals("Apr-20-2020").get().getMessage();
		double discount = 0;
		for(DealsDTO deal:deals) {
			if(deal.getCategory().equals(product.getCategory())) {
				discount = deal.getDiscount();
				break;
			}
		}
		if(discount>0) {
			double price = product.getOfferPrice()*(1-(discount/100));
			product.setOfferPrice(price);
			price = product.getPrice()-price;
			price*=100;
			product.setDiscount((price/product.getPrice()));
		}
		System.out.println(product.getDisplayName());
		return product;
	}
	@GetMapping("/{productId}")
	public Response<ProductDTO> getProduct(@PathVariable int productId) throws ProductException, InterruptedException, ExecutionException{
		Response<ProductDTO> response = new Response<ProductDTO>();
		ProductDTO product = prodService.getSpecificProduct(productId);
		Future<Response<List<RatingsDTO>>> ratings = hystrixService.getRatings(product.getId());
		product.setRatings(ratings.get().getMessage());
		response.setMessage(product);
		System.out.println(product.getDisplayName());
		response.setCode(HttpStatus.OK.value());
		List<DealsDTO> deals = hystrixService.getDeals("Apr-20-2020").get().getMessage();
		double discount = 0;
		deals = deals.stream().filter(deal->deal.getCategory().equals(product.getCategory())).collect(Collectors.toList());
		for(DealsDTO deal:deals) {
			discount = deal.getDiscount();
		}
		if(discount>0) {
			double price = product.getOfferPrice()*(1-(discount/100));
			product.setOfferPrice(price);
			price = product.getPrice()-price;
			price*=100;
			product.setDiscount((price/product.getPrice()));
		}
		return response;
	}
	
	@GetMapping("/name/{productName}")
	public Response<List<ProductDTO>> getProductsByName(@PathVariable String productName) throws ProductException, InterruptedException, ExecutionException{
		if(productName.equals("all")) return getAllproduct();
		Response<List<ProductDTO>> response = new Response<List<ProductDTO>>();
		List<ProductDTO> productList = prodService.getProducts(productName);
		response.setMessage(productList);
		for(ProductDTO product:response.getMessage()) {
			List<DealsDTO> deals = hystrixService.getDeals("Apr-20-2020").get().getMessage();
			double discount = 0;
			for(DealsDTO deal:deals) {
				if(deal.getCategory().equals(product.getCategory())) {
					discount = deal.getDiscount();
					break;
				}
			}
			if(discount>0) {
				double price = product.getOfferPrice()*(1-(discount/100));
				product.setOfferPrice(price);
				price = product.getPrice()-price;
				price*=100;
				product.setDiscount((price/product.getPrice()));
			}
		}
		response.setCode(HttpStatus.OK.value());
		return response;
	}
	
}
