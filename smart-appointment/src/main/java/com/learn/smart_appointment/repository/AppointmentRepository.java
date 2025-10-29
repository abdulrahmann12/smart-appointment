package com.learn.smart_appointment.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.smart_appointment.entity.Appointment;
import com.learn.smart_appointment.entity.User;
import com.learn.smart_appointment.entity.ProviderProfile;
import com.learn.smart_appointment.entity.Service;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByUser(User user);

	List<Appointment> findByProvider(ProviderProfile provider);

	List<Appointment> findByService(Service service);

	List<Appointment> findByStatus(Appointment.Status status);

	List<Appointment> findByProviderAndStatus(ProviderProfile provider, Appointment.Status status);

	List<Appointment> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

	Optional<Appointment> findFirstByDate(LocalDateTime date);

	boolean existsByUserAndStartTimeAndEndTime(User user, LocalDateTime startTime, LocalDateTime endTime);

	List<Appointment> findByCreatedAtAfter(LocalDateTime afterTime);

	void deleteByProvider(ProviderProfile provider);
}
