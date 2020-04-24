package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.ProductDTO;
import com.infy.entity.Product;
import com.infy.repository.ProductRepository;
import com.infy.util.ProductException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prodRepository;
	
	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = prodRepository.findAll();
		List<ProductDTO> productList = new ArrayList<>();
		for(Product product:products) {
			productList.add(ProductDTO.getDTO(product));
		}
		return productList;
	}

	@Override
	public ProductDTO getSpecificProduct(int productId) throws ProductException{
		// TODO Auto-generated method stub
		Optional<Product> product = prodRepository.findById(productId);
		if(product.isPresent()) {
			return ProductDTO.getDTO(product.get());
		}
		throw new ProductException("Product Does not Exists.");
	}

	@Override
	public List<ProductDTO> getProducts(String productName) throws ProductException{
		// TODO Auto-generated method stub
		Optional<List<Product>> productList = Optional.of(prodRepository.findByDisplayNameStartsWith(productName));
		if(productList.isPresent()&&!productList.get().isEmpty()) {
			List<Product> products = productList.get();
			List<ProductDTO> productsList = new ArrayList<>();
			for(Product product:products) {
				productsList.add(ProductDTO.getDTO(product));
			}
			return productsList;
		}
		throw new ProductException("Such Product Does Not Exists.");
	}

}
