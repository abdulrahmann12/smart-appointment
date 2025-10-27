package com.learn.smart_appointment.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Data
public class CategoryViewDTO {

    private Long categoryId;
    private String name;
    private String description;
    private String image;

    private Long parentId;
    private String parentName;

    private List<CategoryChildDTO> childNames; 

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
