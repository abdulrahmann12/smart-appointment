package com.learn.smart_appointment.exception;

public class InsufficientStockException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InsufficientStockException(String message) {
		super(message);
	}
	
}