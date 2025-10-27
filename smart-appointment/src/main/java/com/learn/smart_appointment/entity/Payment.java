package com.learn.smart_appointment.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "payments",
    indexes = {
        @Index(name = "idx_payment_appointment", columnList = "appointment_id"),
        @Index(name = "idx_payment_user", columnList = "user_id")
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String transactionId;

    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum PaymentMethod {
        CASH,
        CREDIT_CARD,
        PAYPAL
    }

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED,
        REFUNDED
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.paymentDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
