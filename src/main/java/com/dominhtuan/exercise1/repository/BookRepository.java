package com.dominhtuan.exercise1.repository;

import com.dominhtuan.exercise1.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findByAuthorEntity_NameContainingIgnoreCaseOrNameContainingIgnoreCase(String nameAuthor,String name);
    void deleteByIdIn(List<Long> ids);
    List<BookEntity> findAllByIdIn(List<Long> ids);
}
