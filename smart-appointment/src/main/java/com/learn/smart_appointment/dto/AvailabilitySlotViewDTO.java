package com.learn.smart_appointment.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.learn.smart_appointment.entity.AvailabilitySlot;

import lombok.*;

@Data
public class AvailabilitySlotViewDTO {

    private Long slotId;

    private Long providerId;
    private String providerName;

    private AvailabilitySlot.DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
