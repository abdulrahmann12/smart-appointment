package com.learn.smart_appointment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class AuditLogAddDTO {

    @NotNull(message = "Actor ID is required")
    private Long actorId;

    @NotBlank(message = "Action is required")
    private String action;

    private String description;

    @NotBlank(message = "Entity name is required")
    private String entityName;

    @NotNull(message = "Entity ID is required")
    private Long entityId;

    private String ipAddress;
}
