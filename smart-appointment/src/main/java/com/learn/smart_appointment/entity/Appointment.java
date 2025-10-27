package com.learn.smart_appointment.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(
    name = "appointments",
    indexes = {
        @Index(name = "idx_appointment_user", columnList = "user_id"),
        @Index(name = "idx_appointment_provider", columnList = "provider_id"),
        @Index(name = "idx_appointment_service", columnList = "service_id"),
        @Index(name = "idx_appointment_date", columnList = "date")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    // user who booked
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // provider for the appointment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private ProviderProfile provider;

    // slot used (if any)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id")
    private AvailabilitySlot slot;

    // service chosen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

 // ✅ One-to-One: each appointment has one payment
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Payment payment;

    // calendar event mapping (one-to-one or one-to-many depending on design) — diagram shows CalendarEvent FK to appointment
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private CalendarEvent calendarEvent;

 // ✅ One-to-Many: an appointment can have multiple reviews
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Status {
        PENDING,
        CONFIRMED,
        COMPLETED,
        CANCELLED
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
