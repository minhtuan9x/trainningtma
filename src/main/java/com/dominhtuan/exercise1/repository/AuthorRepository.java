package com.dominhtuan.exercise1.repository;

import com.dominhtuan.exercise1.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
}
