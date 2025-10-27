package com.learn.smart_appointment.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "provider_profiles", indexes = { @Index(name = "idx_provider_user", columnList = "user_id"),
		@Index(name = "idx_provider_category", columnList = "category_id") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long providerId;

	@Column(columnDefinition = "TEXT")
	private String bio;

	private Integer experienceYears;
	private Double rating;
	private Integer ratingCount;

	private String location;

	// owner user
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private User user;

	// category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	// services offered by this provider
	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<Service> services = new ArrayList<>();

	// availability slots
	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<AvailabilitySlot> availabilitySlots = new ArrayList<>();

	// reviews about this provider
	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<Review> reviews = new ArrayList<>();

	// appointments handled by this provider
	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<Appointment> appointments = new ArrayList<>();

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
