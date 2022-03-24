package com.dominhtuan.exercise1.repository;

import com.dominhtuan.exercise1.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    List<RoleEntity> findAllByCodeIn(List<String> roles);
}
