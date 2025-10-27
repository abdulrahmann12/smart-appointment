package com.learn.smart_appointment.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class ServiceUpdateDTO {

    @Size(max = 100, message = "Service name must not exceed 100 characters")
    private String name;

    @Size(max = 2000, message = "Description must not exceed 2000 characters")
    private String description;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer durationMinutes;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    private Boolean isActive;
}
