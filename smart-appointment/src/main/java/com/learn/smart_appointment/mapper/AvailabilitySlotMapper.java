package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.AvailabilitySlotAddDTO;
import com.learn.smart_appointment.dto.AvailabilitySlotUpdateDTO;
import com.learn.smart_appointment.dto.AvailabilitySlotViewDTO;
import com.learn.smart_appointment.entity.AvailabilitySlot;

@Mapper(componentModel = "spring")
public interface AvailabilitySlotMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "providerId", source = "provider.providerId"),
        @Mapping(target = "providerName", source = "provider.user.username")
    })
    AvailabilitySlotViewDTO toViewDTO(AvailabilitySlot slot);

    // ---------- AddDTO → Entity ----------
    @Mappings({
        @Mapping(target = "slotId", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "appointments", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true),
        @Mapping(target = "dayOfWeek", expression = "java(com.learn.smart_appointment.entity.AvailabilitySlot.DayOfWeek.valueOf(dto.getDayOfWeek()))")
    })
    AvailabilitySlot toEntity(AvailabilitySlotAddDTO dto);

    // ---------- UpdateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "slotId", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "appointments", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true),
        @Mapping(target = "dayOfWeek", expression = "java(com.learn.smart_appointment.entity.AvailabilitySlot.DayOfWeek.valueOf(dto.getDayOfWeek()))")
    })
    AvailabilitySlot toEntity(AvailabilitySlotUpdateDTO dto);
}
