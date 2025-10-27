package com.learn.smart_appointment.dto;

import com.learn.smart_appointment.entity.Notification.NotificationType;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationViewDTO {

    private Long id;

    private Long recipientId;
    
    private String recipientName;

    private String title;

    private String message;

    private NotificationType type;

    private Boolean isRead;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
