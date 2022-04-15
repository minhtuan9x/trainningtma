package com.dominhtuan.exercise1.api.admin;

import com.dominhtuan.exercise1.dto.BookDTO;
import com.dominhtuan.exercise1.dto.response.StaffAssignmentResponse;
import com.dominhtuan.exercise1.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("BookApiOfAdmin")
@RequestMapping("/api/book")
public class BookAPI {
    @Autowired
    private BookService bookService;


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody BookDTO bookDTO) {
        bookService.save(bookDTO);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody List<Long> ids) throws NotFoundException {
        bookService.delete(ids);
        return ResponseEntity.ok().build();
    }
    @ApiImplicitParams(
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    )
    @GetMapping("/{id}")
    public ResponseEntity<List<StaffAssignmentResponse>> getAllStaff(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(bookService.getAllStaffByBook(id));
    }
    @PostMapping("/assignment/{id}")
    public ResponseEntity<Void> assignment(@PathVariable Long id,@RequestBody List<Long> userIds) throws NotFoundException {
        bookService.assignmentBook(id,userIds);
        return ResponseEntity.ok().build();
    }
}
