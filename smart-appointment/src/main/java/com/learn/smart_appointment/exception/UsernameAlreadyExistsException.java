package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class UsernameAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException() {
		super(Messages.USERNAME_ALREADY_EXISTS);
	}
}