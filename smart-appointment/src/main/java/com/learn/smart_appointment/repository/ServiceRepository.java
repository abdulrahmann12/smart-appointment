package com.learn.smart_appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.smart_appointment.entity.Service;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findByProvider_ProviderId(Long providerId);

    List<Service> findByIsActiveTrue();

    List<Service> findByNameContainingIgnoreCase(String name);
}
