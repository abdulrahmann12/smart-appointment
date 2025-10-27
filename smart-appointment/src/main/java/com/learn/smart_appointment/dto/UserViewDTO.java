package com.learn.smart_appointment.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserViewDTO {

    private Long userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private Boolean verified;
}
