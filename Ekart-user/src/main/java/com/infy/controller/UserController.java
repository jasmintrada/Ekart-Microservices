package com.infy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.LoginDTO;
import com.infy.dto.UserDTO;
import com.infy.service.UserServiceImpl;
import com.infy.utils.Response;
import com.infy.utils.UserException;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/login")
	public Response<UserDTO> validateUser(@RequestBody LoginDTO login) throws UserException{
		UserDTO user = userService.isValid(login.getEmail(), login.getPassword());
		Response<UserDTO> response = new Response();
		response.setMessage(user);
		response.setCode(HttpStatus.OK.value());
		return response;
	}
	@PostMapping(value = "/signUp")
	public Response<String> registerUser(@RequestBody UserDTO userDto) throws UserException{
		String msg = userService.registerUser(userDto);
		Response<String> response = new Response();
		response.setMessage(msg);
		response.setCode(HttpStatus.OK.value());
		return response;
	}
	
	@PostMapping("/update")
	public Response<String> updateUser(@RequestBody UserDTO userDTO) throws UserException{
		String msg = userService.updateUser(userDTO);
		Response<String> response = new Response();
		response.setMessage(msg);
		response.setCode(HttpStatus.OK.value());
		return response;
	}
}
