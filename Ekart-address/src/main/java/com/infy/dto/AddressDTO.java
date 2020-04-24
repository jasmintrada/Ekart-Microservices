package com.infy.dto;

import com.infy.entity.Address;

public class AddressDTO {
	private int id;
	private int userId;
	private String addressLine1;
	private String addressLine2;
	private String locality;
	private String pincode;
	private String city;
	private String state;
	private String country;
	private long phoneNo;
	private String userName;
	
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public static AddressDTO getDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressLine1(address.getAddressLine1());
		addressDTO.setAddressLine2(address.getAddressLine2());
		addressDTO.setCity(address.getCity());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setId(address.getId());
		addressDTO.setLocality(address.getLocality());
		addressDTO.setPincode(address.getPincode());
		addressDTO.setState(address.getState());
		addressDTO.setUserId(address.getUserId());
		addressDTO.setPhoneNo(address.getPhoneNo());
		addressDTO.setUserName(address.getUserName());
		return addressDTO;
	}
	public Address getEntity(Address address) {
		Address addressDTO = address;
		if(addressDTO==null) addressDTO = new Address();
		addressDTO.setAddressLine1(this.getAddressLine1());
		addressDTO.setAddressLine2(this.getAddressLine2());
		addressDTO.setCity(this.getCity());
		addressDTO.setCountry(this.getCountry());
		addressDTO.setLocality(this.getLocality());
		addressDTO.setPincode(this.getPincode());
		addressDTO.setState(this.getState());
		addressDTO.setUserId(this.getUserId());
		addressDTO.setPhoneNo(this.getPhoneNo());
		addressDTO.setUserName(this.getUserName());
		return addressDTO;
	}
}
