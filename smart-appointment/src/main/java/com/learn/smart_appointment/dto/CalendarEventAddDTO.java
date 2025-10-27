package com.learn.smart_appointment.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class CalendarEventAddDTO {

    private Long appointmentId;

    @NotNull(message = "Provider ID is required")
    private Long providerId;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    @NotNull(message = "End time is required")
    private LocalDateTime endTime;

    @NotBlank(message = "Event type is required")
    @Pattern(
        regexp = "AVAILABLE|UNAVAILABLE|HOLIDAY|OTHER",
        message = "Event type must be one of: AVAILABLE, UNAVAILABLE, HOLIDAY, OTHER"
    )
    private String type;
}
