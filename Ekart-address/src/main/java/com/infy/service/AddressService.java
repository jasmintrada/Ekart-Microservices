package com.infy.service;

import java.util.List;

import com.infy.dto.AddressDTO;

public interface AddressService {
	List<AddressDTO> getAddresses(int userId) throws Exception ;
	AddressDTO updateAddress(AddressDTO addressDTO) throws Exception ;
	AddressDTO saveAddress(AddressDTO addressDTO) throws Exception ;
	String deleteAddress(int id) throws Exception ;
	List<AddressDTO> setDefaultAddress(int addressId,int userId) throws Exception;
}
