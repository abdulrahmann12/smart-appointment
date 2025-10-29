package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.ReviewCreateDTO;
import com.learn.smart_appointment.dto.ReviewUpdateDTO;
import com.learn.smart_appointment.dto.ReviewViewDTO;
import com.learn.smart_appointment.entity.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "appointmentId", source = "appointment.appointmentId"),
        @Mapping(target = "authorId", source = "author.userId"),
        @Mapping(target = "authorName", source = "author.username"),
        @Mapping(target = "providerId", source = "provider.providerId"),
        @Mapping(target = "providerName", source = "provider.user.username")
    })
    ReviewViewDTO toViewDTO(Review review);

    // ---------- CreateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "reviewId", ignore = true),
        @Mapping(target = "appointment", ignore = true),
        @Mapping(target = "author", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    Review toEntity(ReviewCreateDTO dto);

    // ---------- UpdateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "reviewId", ignore = true),
        @Mapping(target = "appointment", ignore = true),
        @Mapping(target = "author", ignore = true),
        @Mapping(target = "provider", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    Review toEntity(ReviewUpdateDTO dto);
}
