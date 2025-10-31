package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class MailSendingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public MailSendingException() {
        super(Messages.FAILED_EMAIL);
    }
}