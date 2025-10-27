package com.learn.smart_appointment.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "calendar_events",
    indexes = {
        @Index(name = "idx_calendar_provider", columnList = "provider_id"),
        @Index(name = "idx_calendar_start", columnList = "start_time")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    // appointment
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    // provider reference (diagram had provider_id too)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private ProviderProfile provider;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType type;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum EventType {
        AVAILABLE,
        UNAVAILABLE,
        HOLIDAY,
        OTHER
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
