package com.dominhtuan.exercise1.dto.response;

import com.dominhtuan.exercise1.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookEditResponse extends BaseDTO {
    private String name;
    private int pageCount;
    private int point;
    private List<CategoryResponse> categoryResponses = new ArrayList<>();
    private List<AuthorResponse> authorResponses = new ArrayList<>();
}
