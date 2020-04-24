package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.UserDTO;
import com.infy.entity.User;
import com.infy.repository.UserRepository;
import com.infy.utils.UserException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	public UserDTO isValid(String email,String password) throws UserException {
		User user = userRepo.findByEmailId(email);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return UserDTO.getUserDTO(user);
			}
		}
		throw new UserException("Email Id or Password Does not Exists.");
	}

	@Override
	public String registerUser(UserDTO userDTO) throws UserException {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailId(userDTO.getEmailId());
		if(user!=null) {
			throw new UserException("Email id is already used");
		}
		userRepo.save(userDTO.getUser());
		return "User successfully Registered. Please login to continue.";
	}

	@Override
	public String updateUser(UserDTO userDTO) throws UserException{
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailId(userDTO.getEmailId());
		if(user==null) {
			throw new UserException("User Does Not Exist.");
		}
		User newUser = user;
		if(userDTO.getUserName()!=null)
			newUser.setUserName(userDTO.getUserName());
		if(userDTO.getPassword()!=null){
			newUser.setPassword(userDTO.getPassword());
		}
		userRepo.save(newUser);
		return "Account updated Successfully.";
	}
	
}
