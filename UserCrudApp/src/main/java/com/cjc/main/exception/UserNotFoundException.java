package com.cjc.main.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message)
	{
		super(message);
	}

}
