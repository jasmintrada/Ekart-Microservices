package com.infy.service;

import java.util.List;

import com.infy.dto.RatingsDTO;
import com.infy.utils.RatingsException;

public interface RatingsService {
	List<RatingsDTO> getRatings(int productId) throws RatingsException;
}
