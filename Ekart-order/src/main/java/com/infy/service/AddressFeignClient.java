package com.infy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.dto.AddressDTO;

@FeignClient("AddressMS")
public interface AddressFeignClient {
	@RequestMapping("/address/getAddressById/{addressId}")
	AddressDTO getAddressById(@PathVariable("addressId") int addressId);
	
}
