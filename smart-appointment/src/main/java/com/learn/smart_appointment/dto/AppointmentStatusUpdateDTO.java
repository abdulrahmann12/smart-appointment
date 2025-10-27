package com.learn.smart_appointment.dto;

import com.learn.smart_appointment.entity.Appointment;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class AppointmentStatusUpdateDTO {
	
    @NotBlank(message = "Status must not be blank")
    private Appointment.Status status; 
}