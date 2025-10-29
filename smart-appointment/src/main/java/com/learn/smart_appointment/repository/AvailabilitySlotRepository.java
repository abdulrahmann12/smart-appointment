package com.learn.smart_appointment.repository;

import com.learn.smart_appointment.entity.AvailabilitySlot;
import com.learn.smart_appointment.entity.AvailabilitySlot.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, Long> {

    List<AvailabilitySlot> findByProvider_ProviderId(Long providerId);

    List<AvailabilitySlot> findByDayOfWeek(DayOfWeek dayOfWeek);

    List<AvailabilitySlot> findByProvider_ProviderIdAndDayOfWeek(Long providerId, DayOfWeek dayOfWeek);
}
