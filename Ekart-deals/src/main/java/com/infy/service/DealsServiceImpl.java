package com.infy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.DealsDTO;
import com.infy.entity.Deals;
import com.infy.repository.DealsRepository;
import com.infy.util.DealsException;
@Service
public class DealsServiceImpl implements DealsService {

	
	@Autowired
	DealsRepository dealsRepo;
	
	@Override
	public List<DealsDTO> getDeals(String dealDate) throws DealsException {
		// TODO Auto-generated method stub
		List<Deals> deals = dealsRepo.findByDealDate(dealDate);
		if(deals==null||deals.size()==0) throw new DealsException("No deals available for today.");
		List<DealsDTO> dealList = new ArrayList<>();
		for(Deals deal:deals) {
			dealList.add(DealsDTO.getDTO(deal));
		}
		return dealList;
	}

}
