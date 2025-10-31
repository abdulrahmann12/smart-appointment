package com.learn.smart_appointment.exception;

import com.learn.smart_appointment.config.Messages;

public class CategoryNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException() {
		super(Messages.CATEGORY_NOT_FOUND);
	}
	
}