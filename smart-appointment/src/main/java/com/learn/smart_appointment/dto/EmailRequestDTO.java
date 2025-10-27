package com.learn.smart_appointment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequestDTO {

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;
}