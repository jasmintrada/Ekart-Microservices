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
	public List<AddressDTO> saveAddress(@RequestBody AddressDTO addressDTO) throws Exception {
		addressService.saveAddress(addressDTO);
		return addressService.getAddresses(addressDTO.getUserId());
	}
	
	@PostMapping("/updateAddress")
	public List<AddressDTO> updateAddress(@RequestBody AddressDTO addressDTO) throws Exception{
		addressService.updateAddress(addressDTO);
		return addressService.getAddresses(addressDTO.getUserId());
	}
	
	@GetMapping("/delete/{addressId}/{userId}")
	public List<AddressDTO> deleteAddress(@PathVariable int addressId,@PathVariable int userId) throws Exception {
		addressService.deleteAddress(addressId);
		return addressService.getAddresses(userId);
	}
	
	@GetMapping("/setDeafult/{addressId}/{userId}")
	public List<AddressDTO> setDefaultAddress(@PathVariable int addressId,@PathVariable int userId) throws Exception{
		return addressService.setDefaultAddress(addressId, userId);
	}
	
}
