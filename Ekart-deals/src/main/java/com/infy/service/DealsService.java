package com.infy.service;

import java.util.Date;
import java.util.List;

import com.infy.dto.DealsDTO;
import com.infy.util.DealsException;

public interface DealsService {
	List<DealsDTO> getDeals(String dealDate) throws DealsException;
}
