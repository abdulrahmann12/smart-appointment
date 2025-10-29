package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.ProviderProfileCreateDTO;
import com.learn.smart_appointment.dto.ProviderProfileUpdateDTO;
import com.learn.smart_appointment.dto.ProviderProfileViewDTO;
import com.learn.smart_appointment.entity.ProviderProfile;

@Mapper(componentModel = "spring")
public interface ProviderProfileMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "userId", source = "user.userId"),
        @Mapping(target = "userName", source = "user.username"),
        @Mapping(target = "categoryId", source = "category.categoryId"),
        @Mapping(target = "categoryName", source = "category.name")
    })
    ProviderProfileViewDTO toViewDTO(ProviderProfile provider);

    // ---------- CreateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "providerId", ignore = true),
        @Mapping(target = "user", ignore = true),
        @Mapping(target = "category", ignore = true),
        @Mapping(target = "services", ignore = true),
        @Mapping(target = "availabilitySlots", ignore = true),
        @Mapping(target = "reviews", ignore = true),
        @Mapping(target = "appointments", ignore = true),
        @Mapping(target = "rating", ignore = true),
        @Mapping(target = "ratingCount", ignore = true),
        @Mapping(target = "isActive", constant = "true"),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    ProviderProfile toEntity(ProviderProfileCreateDTO dto);

    // ---------- UpdateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "providerId", ignore = true),
        @Mapping(target = "user", ignore = true),
        @Mapping(target = "category", ignore = true),
        @Mapping(target = "services", ignore = true),
        @Mapping(target = "availabilitySlots", ignore = true),
        @Mapping(target = "reviews", ignore = true),
        @Mapping(target = "appointments", ignore = true),
        @Mapping(target = "rating", ignore = true),
        @Mapping(target = "ratingCount", ignore = true),
        @Mapping(target = "isActive", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    ProviderProfile toEntity(ProviderProfileUpdateDTO dto);
}
