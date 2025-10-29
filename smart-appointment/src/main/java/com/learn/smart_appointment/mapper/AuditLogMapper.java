package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.AuditLogAddDTO;
import com.learn.smart_appointment.dto.AuditLogViewDTO;
import com.learn.smart_appointment.entity.AuditLog;

@Mapper(componentModel = "spring")
public interface AuditLogMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "actorId", source = "actor.userId"),
        @Mapping(target = "actorName", source = "actor.username")
    })
    AuditLogViewDTO toViewDTO(AuditLog auditLog);

    // ---------- AddDTO → Entity ----------
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "actor", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    AuditLog toEntity(AuditLogAddDTO dto);
}
