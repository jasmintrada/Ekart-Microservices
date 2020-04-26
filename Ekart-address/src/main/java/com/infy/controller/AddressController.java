package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.AddressDTO;
import com.infy.service.AddressServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressServiceImpl addressService;
	
	@GetMapping("/getAddress/{userId}")
	public List<AddressDTO> getAddressbyUserId(@PathVariable int userId) throws Exception{
		return addressService.getAddresses(userId);
	} 
	
	@PostMapping("/saveAddress")
	public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO) throws Exception {
		return addressService.saveAddress(addressDTO);
	}
	
	@PostMapping("/updateAddress")
	public AddressDTO updateAddress(@RequestBody AddressDTO addressDTO) throws Exception{
		return addressService.updateAddress(addressDTO);
	}
	
	@GetMapping("/delete/{addressId}")
	public void deleteAddress(@PathVariable int addressId) throws Exception {
		addressService.deleteAddress(addressId);
	}
	
}
