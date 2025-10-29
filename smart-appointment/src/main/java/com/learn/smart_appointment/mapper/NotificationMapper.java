package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.NotificationCreateDTO;
import com.learn.smart_appointment.dto.NotificationViewDTO;
import com.learn.smart_appointment.entity.Notification;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "recipientId", source = "recipient.userId"),
        @Mapping(target = "recipientName", source = "recipient.username")
    })
    NotificationViewDTO toViewDTO(Notification notification);

    // ---------- CreateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "recipient", ignore = true),
        @Mapping(target = "isRead", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    Notification toEntity(NotificationCreateDTO dto);
}
