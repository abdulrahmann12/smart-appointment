package com.learn.smart_appointment.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
public class ReviewViewDTO {

    private Long reviewId;

    private Long appointmentId;

    private Long authorId;
    private String authorName;

    private Long providerId;
    private String providerName;

    private Integer rating;
    private String comment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
