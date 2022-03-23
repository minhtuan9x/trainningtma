package com.dominhtuan.exercise1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookDTO extends BaseDTO{
    private String name;
    private int pageCount;
    private int point;
    private Long authorId;
    private List<Long> categoryIds = new ArrayList<>();
}
