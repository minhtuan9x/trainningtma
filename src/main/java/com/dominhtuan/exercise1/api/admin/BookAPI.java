package com.dominhtuan.exercise1.api.admin;

import com.dominhtuan.exercise1.dto.BookDTO;
import com.dominhtuan.exercise1.service.BookService;
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
}
