package com.learn.smart_appointment.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
public class AuditLogViewDTO {

    private Long id;

    private Long actorId;
    private String actorName;

    private String action;
    private String description;

    private String entityName;
    private Long entityId;

    private String ipAddress;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
