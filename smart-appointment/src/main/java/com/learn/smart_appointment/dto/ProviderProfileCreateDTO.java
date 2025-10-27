package com.learn.smart_appointment.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class ProviderProfileCreateDTO {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    @NotBlank(message = "Bio is required")
    private String bio;

    @NotNull(message = "Experience years are required")
    @Min(value = 0, message = "Experience years cannot be negative")
    private Integer experienceYears;

    @NotBlank(message = "Location is required")
    private String location;
}
