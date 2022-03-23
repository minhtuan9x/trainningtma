package com.dominhtuan.exercise1.service.impl;

import com.dominhtuan.exercise1.converter.AuthorConverter;
import com.dominhtuan.exercise1.converter.BookConverter;
import com.dominhtuan.exercise1.converter.CategoryConverter;
import com.dominhtuan.exercise1.dto.BookDTO;
import com.dominhtuan.exercise1.dto.response.BookEditResponse;
import com.dominhtuan.exercise1.dto.response.BookResponse;
import com.dominhtuan.exercise1.repository.AuthorRepository;
import com.dominhtuan.exercise1.repository.BookRepository;
import com.dominhtuan.exercise1.repository.CategoryRepository;
import com.dominhtuan.exercise1.service.BookService;
import com.dominhtuan.exercise1.util.ValidateUtils;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookConverter bookConverter;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;
    private AuthorConverter authorConverter;
    private CategoryConverter categoryConverter;

    public BookServiceImpl(BookRepository bookRepository, BookConverter bookConverter, AuthorRepository authorRepository, CategoryRepository categoryRepository, AuthorConverter authorConverter, CategoryConverter categoryConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.authorConverter = authorConverter;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public List<BookResponse> findAll(String query) {
        return ValidateUtils.isValid(query) ? bookRepository.findByAuthorEntity_NameContainingIgnoreCaseOrNameContainingIgnoreCase(query, query).stream().map(item -> bookConverter.toBookResponse(item)).collect(Collectors.toList())
                : bookRepository.findAll().stream().map(item -> bookConverter.toBookResponse(item)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(BookDTO bookDTO) {
        try {
            bookRepository.save(bookConverter.toBookEntity(bookDTO));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookEditResponse findOne(Long id) throws NotFoundException {
        BookEditResponse bookEditResponse;
        if (Objects.nonNull(id))
            bookEditResponse = bookConverter.toBookEditResponse(bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found book")));
        else {
            bookEditResponse = new BookEditResponse();
            bookEditResponse.setAuthorResponses(authorRepository.findAll().stream().map(authorConverter::toAuthorResponse).collect(Collectors.toList()));
            bookEditResponse.setCategoryResponses(categoryRepository.findAll().stream().map(categoryConverter::toCategoryResponse).collect(Collectors.toList()));
        }
        return bookEditResponse;
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) throws NotFoundException {
        if(bookRepository.findAllByIdIn(ids).size()!=ids.size())
            throw new NotFoundException("Not found Book");
        bookRepository.deleteByIdIn(ids);
    }
}
