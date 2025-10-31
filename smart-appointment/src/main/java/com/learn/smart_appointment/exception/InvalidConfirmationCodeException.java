package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class InvalidConfirmationCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidConfirmationCodeException() {
        super(Messages.INVALID_CONFIRM_EMAIL);
    }
}