package com.infy.service;

import java.util.List;

import com.infy.dto.ProductDTO;
import com.infy.entity.Product;
import com.infy.util.ProductException;

public interface ProductService {
	List<ProductDTO> getAllProducts();
	ProductDTO getSpecificProduct(int productId) throws ProductException;
	List<ProductDTO> getProducts(String productName) throws ProductException;
}
