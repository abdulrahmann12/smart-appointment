package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.learn.smart_appointment.dto.*;
import com.learn.smart_appointment.entity.Service;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    // تحويل من Entity إلى ViewDTO
    @Mapping(target = "providerId", source = "provider.providerId")
    @Mapping(target = "providerName", source = "provider.user.username")
    ServiceViewDTO toDTO(Service service);

    // تحويل من CreateDTO إلى Entity
    @Mapping(target = "serviceId", ignore = true)
    @Mapping(target = "provider", ignore = true)
    @Mapping(target = "appointments", ignore = true)
    @Mapping(target = "isActive", constant = "true") 
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Service toEntity(ServiceCreateDTO dto);

    // تحويل من UpdateDTO إلى Entity
    @Mapping(target = "serviceId", ignore = true)
    @Mapping(target = "provider", ignore = true)
    @Mapping(target = "appointments", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Service toEntity(ServiceUpdateDTO dto);
}
