package com.learn.smart_appointment.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderProfileViewDTO {

    private Long providerId;

    private Long userId;
    private String userName;

    private Long categoryId;
    private String categoryName;

    private String bio;
    private Integer experienceYears;
    private Double rating;
    private Integer ratingCount;
    private String location;

    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}