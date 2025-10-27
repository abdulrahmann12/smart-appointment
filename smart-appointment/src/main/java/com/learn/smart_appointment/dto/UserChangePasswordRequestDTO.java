package com.learn.smart_appointment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserChangePasswordRequestDTO {

	@NotBlank(message = "Current password is required")
    private String currentPassword;
    
	@NotBlank(message = "New password is required")
    @Size(min = 6, message = "New password too short")
    private String newPassword;
}