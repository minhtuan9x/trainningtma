package com.dominhtuan.exercise1.service;

import com.dominhtuan.exercise1.dto.BookDTO;
import com.dominhtuan.exercise1.dto.response.BookEditResponse;
import com.dominhtuan.exercise1.dto.response.BookResponse;
import com.dominhtuan.exercise1.dto.response.StaffAssignmentResponse;
import javassist.NotFoundException;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll(String query);
    void save(BookDTO bookDTO);
    BookEditResponse findOne(Long id) throws NotFoundException;
    void delete(List<Long> ids) throws NotFoundException;
    void assignmentBook(Long bookId,List<Long> staffIds) throws NotFoundException;
    List<StaffAssignmentResponse> getAllStaffByBook(Long bookId) throws NotFoundException;
}
