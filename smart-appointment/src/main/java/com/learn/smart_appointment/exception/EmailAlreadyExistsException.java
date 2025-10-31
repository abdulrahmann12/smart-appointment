package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class EmailAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException() {
		super(Messages.EMAIL_ALREADY_EXISTS);
	}
	
}