package com.learn.smart_appointment.repository;

import com.learn.smart_appointment.entity.CalendarEvent;
import com.learn.smart_appointment.entity.CalendarEvent.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {

    List<CalendarEvent> findByProvider_ProviderId(Long providerId);

    List<CalendarEvent> findByType(EventType type);

    List<CalendarEvent> findByProvider_ProviderIdAndType(Long providerId, EventType type);

    List<CalendarEvent> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
