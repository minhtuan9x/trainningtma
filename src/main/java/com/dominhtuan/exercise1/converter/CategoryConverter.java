package com.dominhtuan.exercise1.converter;

import com.dominhtuan.exercise1.dto.response.CategoryResponse;
import com.dominhtuan.exercise1.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryResponse toCategoryResponse(CategoryEntity categoryEntity){
        CategoryResponse categoryResponse = modelMapper.map(categoryEntity,CategoryResponse.class);
        return categoryResponse;
    }
}
