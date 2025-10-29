package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.CalendarEventAddDTO;
import com.learn.smart_appointment.dto.CalendarEventUpdateDTO;
import com.learn.smart_appointment.dto.CalendarEventViewDTO;
import com.learn.smart_appointment.entity.CalendarEvent;

@Mapper(componentModel = "spring")
public interface CalendarEventMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "appointmentId", source = "appointment.appointmentId"),
        @Mapping(target = "providerId", source = "provider.providerId"),
        @Mapping(target = "providerName", source = "provider.user.username")
    })
    CalendarEventViewDTO toViewDTO(CalendarEvent event);

    // ---------- AddDTO → Entity ----------
    @Mappings({
        @Mapping(target = "eventId", ignore = true),
        @Mapping(target = "appointment", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true),
        @Mapping(target = "type", expression = "java(com.learn.smart_appointment.entity.CalendarEvent.EventType.valueOf(dto.getType()))")
    })
    CalendarEvent toEntity(CalendarEventAddDTO dto);

    // ---------- UpdateDTO → (partial update on existing entity) ----------
    @Mappings({
        @Mapping(target = "eventId", ignore = true),
        @Mapping(target = "appointment", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true),
        @Mapping(target = "type", expression = "java(com.learn.smart_appointment.entity.CalendarEvent.EventType.valueOf(dto.getType()))")
    })
    CalendarEvent toEntity(CalendarEventUpdateDTO dto);
}
