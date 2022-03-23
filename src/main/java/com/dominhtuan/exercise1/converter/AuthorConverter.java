package com.dominhtuan.exercise1.converter;

import com.dominhtuan.exercise1.dto.response.AuthorResponse;
import com.dominhtuan.exercise1.entity.AuthorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    @Autowired
    private ModelMapper modelMapper;

    public AuthorResponse toAuthorResponse(AuthorEntity authorEntity){
        AuthorResponse authorResponse = modelMapper.map(authorEntity,AuthorResponse.class);
        return authorResponse;
    }
}
