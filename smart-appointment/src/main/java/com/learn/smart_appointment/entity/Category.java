package com.learn.smart_appointment.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "categories",
    indexes = {
        @Index(name = "idx_category_name", columnList = "name", unique = true)
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    
    private String image;
    
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    	
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Category> children = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ProviderProfile> providers = new ArrayList<>();

    
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
