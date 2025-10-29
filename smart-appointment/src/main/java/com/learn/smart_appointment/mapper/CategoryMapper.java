package com.learn.smart_appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.learn.smart_appointment.dto.CategoryAddDTO;
import com.learn.smart_appointment.dto.CategoryUpdateDTO;
import com.learn.smart_appointment.dto.CategoryViewDTO;
import com.learn.smart_appointment.dto.CategoryChildDTO;
import com.learn.smart_appointment.entity.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // ---------- Entity → ViewDTO ----------
    @Mappings({
        @Mapping(target = "parentId", source = "parent.categoryId"),
        @Mapping(target = "parentName", source = "parent.name"),
        @Mapping(target = "childNames", source = "children")
    })
    CategoryViewDTO toViewDTO(Category category);

    // ---------- Entity → ChildDTO ----------
    @Mappings({
        @Mapping(target = "id", source = "categoryId"),
        @Mapping(target = "name", source = "name")
    })
    CategoryChildDTO toChildDTO(Category category);

    // ---------- AddDTO → Entity ----------
    @Mappings({
        @Mapping(target = "categoryId", ignore = true),
        @Mapping(target = "parent", ignore = true),
        @Mapping(target = "children", ignore = true),
        @Mapping(target = "providers", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    Category toEntity(CategoryAddDTO dto);

    // ---------- UpdateDTO → Entity ----------
    @Mappings({
        @Mapping(target = "categoryId", ignore = true),
        @Mapping(target = "parent", ignore = true),
        @Mapping(target = "children", ignore = true),
        @Mapping(target = "providers", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true)
    })
    Category toEntity(CategoryUpdateDTO dto);

    // ---------- List Mapping ----------
    List<CategoryChildDTO> toChildDTOList(List<Category> categories);
}
