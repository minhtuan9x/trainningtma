package com.dominhtuan.exercise1.converter;

import com.dominhtuan.exercise1.dto.BookDTO;
import com.dominhtuan.exercise1.dto.response.AuthorResponse;
import com.dominhtuan.exercise1.dto.response.BookEditResponse;
import com.dominhtuan.exercise1.dto.response.BookResponse;
import com.dominhtuan.exercise1.dto.response.CategoryResponse;
import com.dominhtuan.exercise1.entity.AuthorEntity;
import com.dominhtuan.exercise1.entity.BaseEntity;
import com.dominhtuan.exercise1.entity.BookEntity;
import com.dominhtuan.exercise1.entity.CategoryEntity;
import com.dominhtuan.exercise1.repository.AuthorRepository;
import com.dominhtuan.exercise1.repository.CategoryRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BookConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public BookResponse toBookResponse(BookEntity bookEntity) {
        BookResponse bookResponse = modelMapper.map(bookEntity, BookResponse.class);
        if (Objects.nonNull(bookEntity.getAuthorEntity())) {
            bookResponse.setAuthor(bookEntity.getAuthorEntity().getName());
        }
        if (bookEntity.getCategoryEntities().size() > 0) {
            bookResponse.setCategories(bookEntity.getCategoryEntities().stream().map(CategoryEntity::getName).collect(Collectors.joining(",")));
        }
        return bookResponse;
    }

    public BookEntity toBookEntity(BookDTO bookDTO) throws NotFoundException {
        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);
        if (Objects.nonNull(bookDTO.getAuthorId())) {
            AuthorEntity authorEntity = authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(() -> new NotFoundException("Not found author"));
            bookEntity.setAuthorEntity(authorEntity);
        }
        if (bookDTO.getCategoryIds().size() > 0) {
            List<CategoryEntity> categoryEntityList = categoryRepository.findAllById(bookDTO.getCategoryIds());
            if (categoryEntityList.size() != bookDTO.getCategoryIds().size())
                throw new NotFoundException("Not found category");
            bookEntity.setCategoryEntities(categoryEntityList);
        }
        return bookEntity;
    }

    public BookEditResponse toBookEditResponse(BookEntity bookEntity) {
        BookEditResponse bookEditResponse = modelMapper.map(bookEntity, BookEditResponse.class);
        List<CategoryResponse> categoryResponses = categoryRepository.findAll().stream().map(item -> modelMapper.map(item, CategoryResponse.class)).collect(Collectors.toList());
        List<AuthorResponse> authorResponses = authorRepository.findAll().stream().map(item -> modelMapper.map(item, AuthorResponse.class)).collect(Collectors.toList());
        for (CategoryResponse item : categoryResponses) {
            if (bookEntity.getCategoryEntities().stream().map(BaseEntity::getId).collect(Collectors.toList()).contains(item.getId())) {
                item.setChecked("checked");
            }
        }
        for (AuthorResponse item : authorResponses) {
            if (Objects.equals(item.getId(), bookEntity.getAuthorEntity().getId()))
                item.setSelected("selected");
        }
        bookEditResponse.setCategoryResponses(categoryResponses);
        bookEditResponse.setAuthorResponses(authorResponses);
        return bookEditResponse;
    }
}
