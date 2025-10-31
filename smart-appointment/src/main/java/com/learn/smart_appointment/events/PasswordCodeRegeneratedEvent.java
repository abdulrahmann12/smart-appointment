package com.learn.smart_appointment.events;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordCodeRegeneratedEvent {
    private String email;
    private String username;
    private String code;
}