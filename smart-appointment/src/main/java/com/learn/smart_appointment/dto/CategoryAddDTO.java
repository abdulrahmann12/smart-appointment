package com.learn.smart_appointment.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class CategoryAddDTO {

    @NotBlank(message = "Category name is required")
    private String name;

    @NotBlank(message = "Category description is required")
    private String description;
    private String image;

    private Long parentId; 
}
