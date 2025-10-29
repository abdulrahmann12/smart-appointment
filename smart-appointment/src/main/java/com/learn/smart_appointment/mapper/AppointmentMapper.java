package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.AppointmentAddDTO;
import com.learn.smart_appointment.dto.AppointmentUpdateDTO;
import com.learn.smart_appointment.dto.AppointmentViewDTO;
import com.learn.smart_appointment.entity.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "userId", source = "user.userId"),
        @Mapping(target = "username", source = "user.username"),
        @Mapping(target = "providerId", source = "provider.providerId"),
        @Mapping(target = "providerName", source = "provider.user.username"), 
        @Mapping(target = "serviceId", source = "service.serviceId"),
        @Mapping(target = "serviceName", source = "service.name"),
        @Mapping(target = "status", source = "status")
    })
    AppointmentViewDTO toViewDTO(Appointment appointment);

    // ---------- AddDTO → Entity ----------
    @Mappings({
        @Mapping(target = "appointmentId", ignore = true),
        @Mapping(target = "user", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "service", ignore = true),
        @Mapping(target = "slot", ignore = true),
        @Mapping(target = "payment", ignore = true),
        @Mapping(target = "calendarEvent", ignore = true),
        @Mapping(target = "reviews", ignore = true),
        @Mapping(target = "status", constant = "PENDING"),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    Appointment toEntity(AppointmentAddDTO dto);

    // ---------- UpdateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "appointmentId", ignore = true),
        @Mapping(target = "user", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "service", ignore = true),
        @Mapping(target = "slot", ignore = true),
        @Mapping(target = "payment", ignore = true),
        @Mapping(target = "calendarEvent", ignore = true),
        @Mapping(target = "reviews", ignore = true),
        @Mapping(target = "status", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    Appointment toEntity(AppointmentUpdateDTO dto);
}
