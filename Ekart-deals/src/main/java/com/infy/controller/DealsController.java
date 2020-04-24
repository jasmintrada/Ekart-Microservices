package com.infy.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.DealsDTO;
import com.infy.service.DealsServiceImpl;
import com.infy.util.DealsException;
import com.infy.util.Response;

@RestController
@CrossOrigin
@RequestMapping("/deals")
public class DealsController {
	@Autowired
	private DealsServiceImpl dealsService;
	
	@GetMapping("/getDeals/{dealDate}")
	public Response<List<DealsDTO>> getDealsDTO(@PathVariable String dealDate) throws DealsException{
		Response<List<DealsDTO>> response = new Response<>();
		List<DealsDTO> deals = dealsService.getDeals(dealDate);
		response.setMessage(deals);
		response.setCode(HttpStatus.OK.value());
		return response;
	}
	
}