package com.learn.smart_appointment.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users", indexes = { @Index(name = "idx_user_email", columnList = "email", unique = true),
		@Index(name = "idx_user_username", columnList = "username", unique = true) })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	private String firstName;
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Role role;

	private Boolean isActive;
	private String confirmationCode;
	private String imageUrl;
	private Boolean verified;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<Appointment> appointments = new ArrayList<>();

	@OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<Notification> notifications = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<Payment> payments = new ArrayList<>();

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Builder.Default
	private List<Review> reviews = new ArrayList<>();

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ProviderProfile providerProfile;

	@OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Builder.Default
	private List<AuditLog> auditLogs = new ArrayList<>();

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return Boolean.TRUE.equals(isActive);
	}

	public enum Role {
		ADMIN, PROVIDER, CLIENT
	}
}
