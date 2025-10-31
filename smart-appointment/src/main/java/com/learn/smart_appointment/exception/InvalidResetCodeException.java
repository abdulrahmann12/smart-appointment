package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class InvalidResetCodeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public InvalidResetCodeException() {
        super(Messages.INVALID_RESET_CODE);
    }
}