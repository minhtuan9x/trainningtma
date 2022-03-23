package com.dominhtuan.exercise1.dto.response;

import com.dominhtuan.exercise1.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorResponse extends BaseDTO {
    private String name;
    private String surName;
    private String selected = "";
}
