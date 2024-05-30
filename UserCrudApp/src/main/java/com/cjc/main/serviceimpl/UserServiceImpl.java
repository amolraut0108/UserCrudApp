package com.cjc.main.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.exception.UserNotFoundException;
import com.cjc.main.model.User;
import com.cjc.main.repository.UserRepository;
import com.cjc.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired UserRepository userRepository;

	@Override
	public User saveUserDetails(User user) {
	
		   User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User getSingleUser(int id) {
		    /*
		     * User class is introduced in jdk 1.8
		     * To avoid NullPointerException
		     */
		   Optional<User> opUser = userRepository.findById(id);
		     if(opUser.isPresent())
		     {
		    	 User user=opUser.get();
		    	 return user;
		     }
		     else {
		    	 // raise custom Exception
		    	throw new UserNotFoundException("No Record Found For ID:- "+id);
		     }
		   
		 
	}

}
