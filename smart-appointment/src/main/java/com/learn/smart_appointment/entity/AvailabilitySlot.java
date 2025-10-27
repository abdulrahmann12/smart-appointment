package com.learn.smart_appointment.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "availability_slots",
    indexes = {
        @Index(name = "idx_slot_provider", columnList = "provider_id"),
        @Index(name = "idx_slot_day", columnList = "day_of_week")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailabilitySlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private ProviderProfile provider;

    // appointments that used this slot (likely one-to-many but probably one appointment per slot)
    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default private List<Appointment> appointments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;

    private LocalTime startTime;
    private LocalTime endTime;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum DayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
}
