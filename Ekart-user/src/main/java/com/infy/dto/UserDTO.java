package com.infy.dto;

import com.infy.entity.User;

public class UserDTO {
	private int id;
	private String emailId;
	private String userName;
	private String password;
	private String accountType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public static UserDTO getUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setAccountType(user.getAccountType());
		userDTO.setEmailId(user.getEmailId());
		userDTO.setUserName(user.getUserName());
		userDTO.setId(user.getId());
		return userDTO;
	}
	public User getUser() {
		User user = new User();
		user.setAccountType(this.getAccountType());
		user.setEmailId(this.getEmailId());
		user.setPassword(this.getPassword());
		user.setUserName(this.getUserName());
		return user;
	}
}
