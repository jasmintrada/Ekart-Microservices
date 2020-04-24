package com.infy.service;

import com.infy.dto.UserDTO;
import com.infy.utils.UserException;

public interface UserService {
	UserDTO isValid(String email,String password) throws UserException;
	String registerUser(UserDTO userDTO) throws UserException;
	String updateUser(UserDTO userDTO) throws UserException;
}
