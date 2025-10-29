package com.learn.smart_appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.smart_appointment.entity.Review;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProvider_ProviderId(Long providerId);

    List<Review> findByAuthor_UserId(Long authorId);

    Optional<Review> findByAppointment_AppointmentId(Long appointmentId);

    List<Review> findByRating(Integer rating);
}
