package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super(Messages.USER_NOT_FOUND);
	}
}