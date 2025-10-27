package com.learn.smart_appointment.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "services",
    indexes = {
        @Index(name = "idx_service_provider", columnList = "provider_id"),
        @Index(name = "idx_service_name", columnList = "name")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer durationMinutes;

    private BigDecimal price;

    // provider who offers this service
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private ProviderProfile provider;


    // appointments booked for this service (optional back ref)
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default private List<Appointment> appointments = new ArrayList<>();

    private Boolean isActive;

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
}
