package com.dominhtuan.exercise1.repository;

import com.dominhtuan.exercise1.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
