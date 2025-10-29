package com.learn.smart_appointment.repository;

import com.learn.smart_appointment.entity.Payment;
import com.learn.smart_appointment.entity.Payment.PaymentStatus;
import com.learn.smart_appointment.entity.Payment.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByUser_UserId(Long userId);

    Optional<Payment> findByAppointment_AppointmentId(Long appointmentId);

    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByMethod(PaymentMethod method);

    Optional<Payment> findByTransactionId(String transactionId);
}
