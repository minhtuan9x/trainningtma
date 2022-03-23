package com.dominhtuan.exercise1.repository;

import com.dominhtuan.exercise1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserName(String userName);
    List<UserEntity> findAllByIdIn(List<Long> ids);
    List<UserEntity> findAllByRoleEntities_Code(String code);
}
