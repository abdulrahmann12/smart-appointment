package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.learn.smart_appointment.dto.*;
import com.learn.smart_appointment.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // ==================== toDTOs ====================

    // User → UserViewDTO
    UserViewDTO toViewDTO(User user);

    // User → AdminUserViewDTO
    @Mapping(target = "role", source = "role")
    AdminUserViewDTO toAdminDTO(User user);

    // User → UserSummaryDTO 
    UserSummaryDTO toSummaryDTO(User user);

    // ==================== toEntities ====================

    // UserCreateDTO → User
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "appointments", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "providerProfile", ignore = true)
    @Mapping(target = "auditLogs", ignore = true)
    @Mapping(target = "role",  constant = "CLIENT")
    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "verified", constant = "false")
    @Mapping(target = "confirmationCode", ignore = true)
    @Mapping(target = "imageUrl", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserCreateDTO dto);

    // UserUpdateDTO → User
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "appointments", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "providerProfile", ignore = true)
    @Mapping(target = "auditLogs", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "verified", ignore = true)
    @Mapping(target = "confirmationCode", ignore = true)
    @Mapping(target = "imageUrl", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserUpdateDTO dto);
}
