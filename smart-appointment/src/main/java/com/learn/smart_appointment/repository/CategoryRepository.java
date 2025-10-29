package com.learn.smart_appointment.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.smart_appointment.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
    Optional<Category> findByName(String name);

    Optional<Category> findFirstByName(String name);

    List<Category> findAllByName(String name);

    List<Category> findByParent_CategoryId(Long parentId);

    List<Category> findByParentIsNull();

}