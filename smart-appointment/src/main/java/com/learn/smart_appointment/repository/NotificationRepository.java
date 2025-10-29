package com.learn.smart_appointment.repository;

import com.learn.smart_appointment.entity.Notification;
import com.learn.smart_appointment.entity.Notification.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByRecipient_UserId(Long recipientId);

    List<Notification> findByRecipient_UserIdAndIsReadFalse(Long recipientId);

    List<Notification> findByType(NotificationType type);

    Long countByRecipient_UserIdAndIsReadFalse(Long recipientId);
}
