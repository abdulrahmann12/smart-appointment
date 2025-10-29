package com.learn.smart_appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.smart_appointment.entity.ProviderProfile;

import java.util.Optional;
import java.util.List;

@Repository
public interface ProviderProfileRepository extends JpaRepository<ProviderProfile, Long> {

    Optional<ProviderProfile> findByUser_UserId(Long userId);

    List<ProviderProfile> findByCategory_CategoryId(Long categoryId);

    List<ProviderProfile> findByIsActiveTrue();

    boolean existsByUser_UserId(Long userId);
}
