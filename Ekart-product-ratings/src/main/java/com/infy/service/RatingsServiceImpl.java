package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.RatingsDTO;
import com.infy.entity.Ratings;
import com.infy.repository.RatingsRepository;
import com.infy.utils.RatingsException;
@Service
public class RatingsServiceImpl implements RatingsService {

	
	@Autowired
	RatingsRepository ratingsRepository;
	@Override
	public List<RatingsDTO> getRatings(int productId) throws RatingsException {
		// TODO Auto-generated method stub
		Optional<List<Ratings>> ratings = Optional.of(ratingsRepository.findByProductId(productId));
		if(ratings.isPresent()) {
			List<Ratings> ratingsList = ratings.get();
			List<RatingsDTO> ratingList = new ArrayList<>();
			for(Ratings rating:ratingsList) {
				ratingList.add(RatingsDTO.getRatingsDTO(rating));
			}
			return ratingList;
		}
		return null;
	}

}
