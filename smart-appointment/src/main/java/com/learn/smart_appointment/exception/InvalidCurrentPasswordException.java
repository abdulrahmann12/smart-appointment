package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class InvalidCurrentPasswordException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public InvalidCurrentPasswordException() {
        super(Messages.INVALID_PASSWORD);
    }
}