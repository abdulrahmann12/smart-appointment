package com.learn.smart_appointment.dto;

import java.time.LocalDateTime;

import com.learn.smart_appointment.entity.CalendarEvent;

import lombok.*;

@Data
public class CalendarEventViewDTO {

    private Long eventId;

    private Long appointmentId;
    private Long providerId;
    private String providerName;

    private String title;
    private String description;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private CalendarEvent.EventType type; 

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
