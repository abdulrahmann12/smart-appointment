package com.learn.smart_appointment.dto;

import com.learn.smart_appointment.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class UserRoleUpdateDTO {

	@NotNull(message = "Role is required")
    private User.Role newRole;
}
