package com.learn.smart_appointment.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "audit_logs",
    indexes = {
        @Index(name = "idx_auditlog_user", columnList = "actor_id"),
        @Index(name = "idx_auditlog_action", columnList = "action")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // actor (user who did the action)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private User actor;
    
    @Column(nullable = false)
    private String action; 

    @Column(columnDefinition = "TEXT")
    private String description;

    private String entityName; 
    private Long entityId; 

    private String ipAddress; 

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
