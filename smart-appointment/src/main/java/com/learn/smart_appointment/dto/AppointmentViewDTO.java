package com.learn.smart_appointment.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
public class AppointmentViewDTO {
    private Long appointmentId;

    private Long userId;
    private String userName;

    private Long providerId;
    private String providerName;

    private Long serviceId;
    private String serviceName;

    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status;
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
