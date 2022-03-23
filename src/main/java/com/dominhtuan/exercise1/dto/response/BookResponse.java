package com.dominhtuan.exercise1.dto.response;

import com.dominhtuan.exercise1.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse extends BaseEntity {
    private String name;
    private int pageCount;
    private int point;

    private String author;
    private String categories;

}
