package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.exception.UserNotFoundException;
import com.cjc.main.model.User;
import com.cjc.main.service.UserService;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		  User savedUser =userService.saveUserDetails(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> exposeUser(@PathVariable int id)
	{
		 User user=userService.getSingleUser(id);
		
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException ue)
	{
		return new ResponseEntity<String>(ue.getMessage(),HttpStatus.NOT_FOUND);
	}

}













