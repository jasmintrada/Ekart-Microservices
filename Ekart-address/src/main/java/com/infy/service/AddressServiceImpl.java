package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.AddressDTO;
import com.infy.entity.Address;
import com.infy.repository.AddressRepository;


@Service
public class AddressServiceImpl implements AddressService {

	

	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public List<AddressDTO> getAddresses(int userId) throws Exception {
		// TODO Auto-generated method stub
		List<Address> addressList = addressRepo.findByUserId(userId);
		if(addressList==null||addressList.size()==0) throw new Exception("User has not saved any address yet.");
		List<AddressDTO> addressDTOList = new ArrayList<>();
		for(Address address : addressList) {
			addressDTOList.add(AddressDTO.getDTO(address));
		}
		if(addressDTOList.size()>1) {
			for(int i=1;i<addressDTOList.size();i++) {
				if(addressDTOList.get(i).isDefaultAddress()) {
					AddressDTO add = addressDTOList.get(i);
					addressDTOList.set(i, addressDTOList.get(0));
					addressDTOList.set(0, add);
					break;
				}
			}
		}
		return addressDTOList;
	}

	@Override
	public AddressDTO updateAddress(AddressDTO addressDTO) throws Exception  {
		// TODO Auto-generated method stub
		Optional<Address> address = addressRepo.findById(addressDTO.getId());
		if(address.isPresent()) {
			Address oldAddress = addressDTO.getEntity(address.get());
			oldAddress = addressRepo.save(oldAddress);
			return AddressDTO.getDTO(oldAddress);
		}
		throw new Exception("No Address Found.");
	}

	@Override
	public AddressDTO saveAddress(AddressDTO addressDTO)  throws Exception {
		// TODO Auto-generated method stub
		Address address = addressRepo.save(addressDTO.getEntity(null));
		return AddressDTO.getDTO(address);
	}

	@Override
	public String deleteAddress(int id) throws Exception {
		// TODO Auto-generated method stub
		addressRepo.deleteById(id);
		return "Success";
	}

	@Override
	public List<AddressDTO> setDefaultAddress(int addressId,int userId) throws Exception {
		// TODO Auto-generated method stub
		List<Address> addresses = addressRepo.findByUserId(userId).stream().map(
				(adrs)->{
					if(adrs.getId()==addressId) 
						adrs.setDefaultAddress(true);
					else
						adrs.setDefaultAddress(false);
					return adrs;
				}).collect(Collectors.toList());
		addressRepo.saveAll(addresses);
		return this.getAddresses(userId);
	}

}
